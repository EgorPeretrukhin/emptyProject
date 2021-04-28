package ru.friden.com.database;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import ru.friden.com.entity.Warehouse;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Warehouse.class}, version = 1, exportSchema = false)
public abstract class WarehouseDataBase extends RoomDatabase {
    private static final int NUMBERS_OF_THREADS = 4;
    static final ExecutorService dataBaseExecutorService = Executors.newFixedThreadPool(NUMBERS_OF_THREADS);
    private static volatile WarehouseDataBase INSTANSE;

    public static Callback getRoomDataBaseCallBack() {
        return roomDataBaseCallBack;
    }

    private static RoomDatabase.Callback roomDataBaseCallBack = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            dataBaseExecutorService.execute(() -> {
                WareHouseDao wareHouseDao = INSTANSE.getWarehouseDao();
                wareHouseDao.deleteAll();
                wareHouseDao.insert(new Warehouse("Samsung", 1230, 2));
                wareHouseDao.insert(new Warehouse("Apple", 1567, 1));
                wareHouseDao.insert(new Warehouse("Xiaomi", 123000, 0));
            });
        }
    };

    static WarehouseDataBase getDataBase(final Context context) {
        if (INSTANSE == null) {
            synchronized (WarehouseDataBase.class) {
                if (INSTANSE == null) {
                    INSTANSE = Room.databaseBuilder(context.getApplicationContext(), WarehouseDataBase.class, "data")
                            .addCallback(getRoomDataBaseCallBack()).build();
                }
            }
        }
        return INSTANSE;
    }

    public abstract WareHouseDao getWarehouseDao();
}

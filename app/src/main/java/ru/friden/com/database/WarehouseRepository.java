package ru.friden.com.database;

import android.app.Application;
import androidx.lifecycle.LiveData;
import ru.friden.com.entity.Warehouse;

import java.util.List;

class WarehouseRepository {
    private WareHouseDao wareHouseDao;
    private LiveData<List<Warehouse>> liveWarehouseList;

    //TODO
    // Обратите внимание, что для модульного тестирования WordRepository необходимо удалить Приложение.
    // зависимость. Это добавляет сложности и намного больше кода, и этот образец не предназначен для тестирования.
    // https://github.com/googlesamples

    WarehouseRepository(Application application) {
        WarehouseDataBase warehouseDataBase = WarehouseDataBase.getDataBase(application);
        wareHouseDao = warehouseDataBase.getWarehouseDao();
        liveWarehouseList = wareHouseDao.getAllWarehouse();
    }

    LiveData<List<Warehouse>> getAllWareHouses() {
        return liveWarehouseList;
    }

    void insert(final Warehouse warehouse) {
        WarehouseDataBase.dataBaseExecutorService.execute(()-> {
            wareHouseDao.insert(warehouse);
        });
    }
}

package ru.friden.com.database;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import ru.friden.com.entity.Warehouse;

import java.util.List;

@Dao
public interface WareHouseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Warehouse warehouses);

    @Update
    void update(Warehouse warehouse);

    @Delete
    void delete(Warehouse warehouse);

    @Query("DELETE FROM Warehouse")
    void deleteAll();

    @Query("SELECT * FROM warehouse")
    LiveData<List<Warehouse>> getAllWarehouse();

    @Query("SELECT * FROM warehouse WHERE name LIKE :warehouseName")
    Warehouse getWarehouseByName(String warehouseName);
}

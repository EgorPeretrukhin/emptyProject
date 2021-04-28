package ru.friden.com.database;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import ru.friden.com.entity.Warehouse;

import java.util.List;


public class WarehouseViewModel extends AndroidViewModel {

    private final LiveData<List<Warehouse>> liveWarehouseList;
    private WarehouseRepository warehouseRepository;


    public WarehouseViewModel(Application application) {
        super(application);
        warehouseRepository = new WarehouseRepository(application);
        liveWarehouseList = warehouseRepository.getAllWareHouses();
    }

    public LiveData<List<Warehouse>> getLiveWarehouseList() {
        return liveWarehouseList;
    }

    public void insert(Warehouse warehouse) {
        warehouseRepository.insert(warehouse);
    }
}

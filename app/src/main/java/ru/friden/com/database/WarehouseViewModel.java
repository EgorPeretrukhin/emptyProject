package ru.friden.com.database;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

public class WarehouseViewModel extends AndroidViewModel {

//    private WarehouseRepository warehouseRepository;
//    private final LiveData<List<Warehouse>> liveWarehouseList;



    public WarehouseViewModel(Application application) {
        super(application);
//        warehouseRepository = new WarehouseRepository(application);
//        liveWarehouseList = warehouseRepository.getAllWareHouses();
    }

//    public LiveData<List<Warehouse>> getLiveWarehouseList() {
//        return liveWarehouseList;
//    }

//    public void insert(Warehouse warehouse) {
//        warehouseRepository.insert(warehouse);
//    }
}

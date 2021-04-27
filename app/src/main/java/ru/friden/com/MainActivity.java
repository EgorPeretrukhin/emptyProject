package ru.friden.com;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import ru.friden.com.database.WarehouseViewModel;
import ru.friden.com.entity.Warehouse;
import ru.friden.com.fragment.BackFragment;
import ru.friden.com.fragment.FrontFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Warehouse> warehouseList;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.front_item:
                    loadFragment(new FrontFragment(warehouseList));
                    return true;
                case R.id.back_item:
                    loadFragment(new BackFragment(warehouseList));
                    return true;
            }
            return false;
        }
    };

    private WarehouseViewModel warehouseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        import data into csv file
        CsvReaderAndWriter csvReaderAndWriter = new CsvReaderAndWriter(this);
        csvReaderAndWriter.readFileCsv();
        warehouseList = csvReaderAndWriter.getWarehouseList();

        //ViewModel
//        warehouseViewModel = new ViewModelProvider(this).get(WarehouseViewModel.class);
//
//        //Room
//        WarehouseDataBase warehouseDataBase = Room.databaseBuilder(this, WarehouseDataBase.class, "qwerty")
//                .addCallback(getRoomDataBaseCallBack()).build();
//        //LiveData
//        LiveData<List<Warehouse>> warehouseListLiveData = warehouseDataBase.getWarehouseDao().getAllWarehouse();
//        warehouseListLiveData.observe(this, warehouses -> warehouseList = warehouses);

        //Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        bottomNavigationView.setSelectedItemId(R.id.front_item);
    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}
package ru.friden.com;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import ru.friden.com.fragment.BackFragment;
import ru.friden.com.fragment.FrontFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Warehouse> warehouseList;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.front_item: loadFragment(new FrontFragment(warehouseList)); return true;
                case R.id.back_item: loadFragment(new BackFragment(warehouseList)); return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CsvReaderAndWriter csvReaderAndWriter = new CsvReaderAndWriter(this);
        csvReaderAndWriter.readFileCsv();
        warehouseList = csvReaderAndWriter.getWarehouseList();

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
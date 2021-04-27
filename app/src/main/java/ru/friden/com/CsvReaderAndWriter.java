package ru.friden.com;

import android.content.Context;
import android.content.res.AssetManager;
import com.opencsv.CSVReader;
import ru.friden.com.entity.Warehouse;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderAndWriter {
    private List<Warehouse> warehouseList = new ArrayList<>();
    private Context context;

    public CsvReaderAndWriter(Context context) {
        this.context = context;
    }

    public void readFileCsv() {
        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open("data.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
            List<String[]> myEntries = reader.readAll();
            for (String[] myEntry : myEntries) {
                Warehouse warehouse = new Warehouse(myEntry[0], Double.parseDouble(myEntry[1]), Integer.parseInt(myEntry[2]));
                warehouseList.add(warehouse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Warehouse> getWarehouseList() {
        return warehouseList;
    }
}
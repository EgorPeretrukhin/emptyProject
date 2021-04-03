package ru.friden.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReaderAndWriter {
    private List<Warehouse> warehouseArrayList = new ArrayList<>();
    private String FILE_PATH = ".\\app\\src\\main\\res\\raw\\data.csv";

    public static void main(String[] args) {
        CsvReaderAndWriter csvReaderAndWriter = new CsvReaderAndWriter();
        csvReaderAndWriter.readCsvFile();
    }

    void readCsvFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                Warehouse warehouse = new Warehouse();
//                System.out.println(line);
                String[] atrr = line.replace("\"", "").split(",");
//                System.out.println(Arrays.toString(atrr));
                warehouse.setName(atrr[0]);
                warehouse.setPrice(Double.parseDouble(atrr[1].trim()));
                warehouse.setQuantity(Integer.parseInt(atrr[2].trim()));
                warehouseArrayList.add(warehouse);
            }
            bufferedReader.close();
            for (Warehouse warehouse : warehouseArrayList) {
                System.out.println(warehouse.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

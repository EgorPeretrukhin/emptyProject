package ru.friden.com.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "warehouse")
public class Warehouse {

    @PrimaryKey 
    @NonNull
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "price")
    private double price;
    @ColumnInfo(name = "quantity")
    private int quantity;
//    @Ignore
//    public Warehouse(@NonNull String name) {
//        this.name = name;
//    }

    public Warehouse(@NonNull String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getPriceToString() {
        return String.valueOf(price);
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getQuantityToString() {
        return String.valueOf(quantity);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        this.quantity++;
    }
    public void decrementQuantity() {
        this.quantity--;
    }
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

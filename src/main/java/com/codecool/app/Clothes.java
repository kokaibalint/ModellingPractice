package com.codecool.app;

import java.util.ArrayList;
import java.util.List;

public class Clothes {
    private int id;
    private String brand;
    private ClothesType clothesType;
    private List<Clothes> clothesOnTheFloor;
    private String color;
    private int size;
    private boolean hanged;
    private boolean onTheFloor;
    private boolean clean;


    public Clothes(int id, String brand, ClothesType clothesType,String color,int size,boolean hanged,boolean onTheFloor,boolean clean) {
        this.id = id;
        this.brand = brand;
        this.clothesType = clothesType;
        this.color = color;
        this.size = size;
        this.hanged = false;
        this.onTheFloor = false;
        this.clean = true;


    }
    public void hanging() {
        hanged = true;
    }
    public String getBrand() {
        return brand;
    }

    public int getId() {
        return id;
    }

    public void setHanged(boolean hanged) {
        this.hanged = hanged;
    }

    public void setOnTheFloor(boolean onTheFloor) {
        this.onTheFloor = onTheFloor;
    }

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Clothes{" +
            "id=" + id +
            ", brand='" + brand + '\'' +
            ", clothesType=" + clothesType +
            ", color='" + color + '\'' +
            ", size=" + size +
            ", hanged=" + hanged +
            ", onTheFloor=" + onTheFloor +
            ", clean=" + clean +
            '}';
    }
}

package com.codecool.app;

import java.util.ArrayList;
import java.util.List;

public class Clothes {
    private int id;
    private String brand;
    private ClothesType clothesType;
    private List<Clothes> clothesOnTheFloor;
    private boolean hanged;

    public Clothes(int id,String brand,ClothesType clothesType) {
        this.id = id;
        this.brand = brand;
        this.hanged = false;
        this.clothesType = clothesType;
        clothesOnTheFloor = new ArrayList<>();
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

    @Override
    public String toString() {
        return "Clothes{" +
            "id=" + id +
            ", brand='" + brand + '\'' +
            ", clothesType=" + clothesType +
            ", hanged=" + hanged +
            '}';
    }
}

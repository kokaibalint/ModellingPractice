package com.codecool.app;

public abstract class Clothes {
    private String brand;
    private boolean hanged;
    private ClothesType clothesType;

    public Clothes(String brand,ClothesType clothesType) {
        this.brand = brand;
        this.hanged = false;
        this.clothesType = clothesType;
    }

    public void hanging() {
        hanged = true;
    }
    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Clothes{" +
            "brand='" + brand + '\'' +
            ", hanged=" + hanged +
            ", clothesType=" + clothesType +
            '}';
    }
}

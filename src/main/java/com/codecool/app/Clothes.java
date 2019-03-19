package com.codecool.app;

public abstract class Clothes {
    private String brand;
    private boolean hanged;

    public Clothes(String brand) {
        this.brand = brand;
        this.hanged = false;
    }

    public void hanging() {
        hanged = true;
    }

    public boolean isHanged(){
        return hanged;
    }

    public String getBrand() {
        return brand;
    }


}

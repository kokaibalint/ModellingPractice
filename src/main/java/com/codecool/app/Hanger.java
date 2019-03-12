package com.codecool.app;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hanger {
    private int id = 0;
    private List<ClothesType> clothesType;

    public Hanger(int id) {
        clothesType = new ArrayList<>();
        this.id = id;
    }

    public void hangerAddClothes(String userClothes) {
        if (userClothes.equals("1")) {
            clothesType.add(ClothesType.JACKET);
        }
        else if (userClothes.equals("2")){
            clothesType.add(ClothesType.JEANS);
        }
        else if(userClothes.equals("3")){
            clothesType.add(ClothesType.TSHIRT);
        }
        else if(userClothes.equals("4")) {
            clothesType.add(ClothesType.SHOES);
        }
        else {
            System.out.println("There is no such clothes.");
        }
        System.out.println(clothesType + " is hanging.");
    }

    public int getId() {
        return id;
    }
}

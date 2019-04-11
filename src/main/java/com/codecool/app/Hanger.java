package com.codecool.app;

import com.codecool.Exceptions.HangerIsFullException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Hanger {
    private int id;
    private int limit;
    private HangerType hangerType;
    private List<Clothes> clothesList;

    public Hanger(int id, HangerType hangerType) {
        this.id = id;
        this.hangerType = hangerType;
        this.clothesList = new ArrayList<Clothes>();
        this.limit = 4;
    }

    public int getId() {
        return id;
    }

    public HangerType getHangerType() {
        return hangerType;
    }

    public int getLimit() {
        return limit;
    }

    public void addClothToHanger(Clothes clothes) {
        clothesList.add(clothes);
        System.out.println("ADDED" + clothesList);
    }


    public void removeClothesFromHanger(int clothesId) {
        Clothes clothes;
        for (Clothes element : clothesList) {
            if(clothesList.contains(clothesId)){
                clothesList.remove(element);
            }
        }
    }

    @Override
    public String toString () {
        return "Hanger{" +
            "id=" + id +
            " hangerType=" + hangerType +
            '}';
    }
}

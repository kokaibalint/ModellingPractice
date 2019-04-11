package com.codecool.app;

import com.codecool.Exceptions.HangerIsFullException;
import com.codecool.Exceptions.NoProperHangerException;

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
        try {
            if (clothes.getClothesType().equals(ClothesType.TOP) && hangerType.equals(HangerType.SINGLE)) {
                clothes.setHanged(true);
                clothesList.add(clothes);
                System.out.println("ADDED" + "\n" + clothesList);
            } else if (clothes.getClothesType().equals(ClothesType.BOTTOM) && hangerType.equals(HangerType.SKIRT)) {
                clothes.setHanged(true);
                clothesList.add(clothes);
                System.out.println("ADDED" + "\n" + clothesList);
            } else {
                throw new NoProperHangerException("You cant make this!");
            }
        } catch (NoProperHangerException e) {
            System.out.println(e.getMessage());
        }
    }


    public void removeClothesFromHanger(Clothes clothes) {
        clothesList.remove(clothes);
        clothes.setHanged(false);
        System.out.println("DELETED" + "\n" + clothesList);
    }

    @Override
    public String toString() {
        return "Hanger{" +
            "id=" + id +
            " hangerType=" + hangerType +
            '}';
    }
}

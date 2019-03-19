package com.codecool.app;

import java.util.ArrayList;
import java.util.List;

public class Hanger {
    private List<Clothes> cloths;

    public Hanger() {
        cloths = new ArrayList<Clothes>();
    }

    public void addClothes(String clothes) {
        cloths.add(clothes);
    }

    public void removeClothes(String clothes) {
        cloths.remove(clothes);
    }

    public List<Clothes> getCloths() {
        return cloths;
    }
}



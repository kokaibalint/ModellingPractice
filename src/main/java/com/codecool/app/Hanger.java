package com.codecool.app;

import java.util.ArrayList;
import java.util.List;

public class Hanger {
    private List<Clothes> cloths;

    public Hanger() {
        cloths = new ArrayList<Clothes>();
    }

    public void addClothes(Clothes clothes) {
        cloths.add(clothes);
    }

    public void removeClothes(Clothes clothes) {
        cloths.remove(clothes);
    }

    public List<Clothes> getCloths() {
        return cloths;
    }
}



package com.codecool.app;

import java.util.ArrayList;
import java.util.List;

public class Wardrobe {
    private List<Hanger> hangerList;
    private int size;

    public Wardrobe() {
        hangerList = new ArrayList<>();
        this.size = size;
    }

    public void addHanger(Hanger hanger) {
        if (hangerList.size() < size) {
            hangerList.add(hanger);
        }
    }

    public List<Hanger> getHangerList() {
        return hangerList;
    }
}

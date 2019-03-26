package com.codecool.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wardrobe {

    private Map<Integer,Clothes> clothesMap = new HashMap<>();
    private List<Hanger> hangerList = new ArrayList<>();
    private List<Clothes> clothes = new ArrayList<>();
    private int size;

    public Wardrobe(int size) {
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

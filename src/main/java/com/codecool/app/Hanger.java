package com.codecool.app;

import java.util.ArrayList;
import java.util.List;

public class Hanger {
    private int id;
    private int limit;
    private List<Clothes> hangedClothes;

    public Hanger(int id) {
        this.id = id;
        hangedClothes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Hanger{" +
            "id=" + id +
            '}';
    }
}



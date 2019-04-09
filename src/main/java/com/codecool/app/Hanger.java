package com.codecool.app;

import java.util.ArrayList;
import java.util.List;

public class Hanger {
    private int id;
    private int limit;
    private HangerType hangerType;

    public Hanger(int id) {
        this.id = id;
        this.limit = 4;
    }

    public int getId() {
        return id;
    }

    public int getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        return "Hanger{" +
            "id=" + id +
            '}';
    }
}



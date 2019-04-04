package com.codecool.app;

import java.util.ArrayList;
import java.util.List;

public class Hanger {
    private int id;
    private int limit;

    public Hanger(int id) {
        this.id = id;
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



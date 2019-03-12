package com.codecool.app;

import java.util.ArrayList;
import java.util.List;

public class Wardrobe {
    private Hanger hanger;
    private List<Hanger> hangerList;

    public Wardrobe() {
        hangerList = new ArrayList<>();
    }

    public void wardrobeAddHanger(String makeHanger){
        if (makeHanger.equals("y")) {
            hangerList.add(new Hanger(1));
            System.out.println("A hanger has been added.");
        }
        else {
            System.out.println("bye bradah!");
        }

    }
}

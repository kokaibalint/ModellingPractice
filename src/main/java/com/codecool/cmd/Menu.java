package com.codecool.cmd;

import com.codecool.app.Wardrobe;

import java.util.Scanner;

public class Menu {

    private Scanner reader = new Scanner(System.in);
    private Wardrobe wardrobe;

    public Menu() {
        wardrobe = createWardrobe();
    }

    public Wardrobe createWardrobe() {
        System.out.println("First you need to set a size of your wardrobe!");
        Wardrobe wardrobe = new Wardrobe(Integer.parseInt(reader.nextLine()));
        return wardrobe;
    }


}

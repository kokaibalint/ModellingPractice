package com.codecool.cmd;

import com.codecool.Exceptions.HangerIsFullException;
import com.codecool.Exceptions.NoSuchColorClothesException;
import com.codecool.Exceptions.NoSuchIdClothesException;
import com.codecool.Exceptions.NoSuchSizeClothesException;
import com.codecool.app.Clothes;
import com.codecool.app.Hanger;
import com.codecool.app.Wardrobe;

import java.util.*;

public class Menu {

    private Scanner reader = new Scanner(System.in);
    private Wardrobe wardrobe;
    private Hanger hanger;
    private Clothes clothes;

    public Menu() {
        wardrobe = new Wardrobe();
    }

    public void start() {
        String[] options = {"Add Clothes", "Add Hanger", "List Clothes", "List Hangers",
            "Search Clothes by color", "Search Clothes by size", "Search Clothes by ID",
            "Add clothes to hanger", "Remove clothes from Hanger", "Exit"};
        while (true) {
            show(options);
            String chosen = reader.nextLine();
            switch (chosen) {
                case "1": {
                    addClothes();
                    break;
                }
                case "2": {
                    addHanger();
                    break;
                }
                case "3": {
                    listClothes();
                    break;
                }
                case "4": {
                    listHangers();
                    break;
                }
                case "5": {
                    System.out.println("Give a color: ");
                    String color = reader.nextLine();
                    try {
                        System.out.println(searchClothesByColor(color).toString());
                    } catch (NoSuchColorClothesException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case "6": {
                    System.out.println("Give a size: ");
                    int size = Integer.valueOf(reader.nextLine());
                    try {
                        System.out.println(searchClothesBySize(size).toString());
                    } catch (NoSuchSizeClothesException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case "7": {
                    System.out.println("Give an ID: ");
                    int clothesId = Integer.valueOf(reader.nextLine());
                    try {
                        System.out.println(searchClothesById(clothesId));
                    } catch (NoSuchIdClothesException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case "8": {
                    try {
                        addClothingToHanger();
                        System.out.println("HOZZÁADVA GECI");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                }
                case "9": {
                    System.out.println("Give the cloth ID: ");
                    int clothesId = Integer.valueOf(reader.nextLine());
                    hanger.removeClothesFromHanger(clothesId);
                    System.out.println("KITÖRÖLVE BASZOD");
                    break;
                }
                case "0": {
                    System.exit(0);
                }
                default:
                    System.out.println("Give me a number pls");
            }
        }

    }

    public void addClothingToHanger() {
        System.out.println("Give your clothes ID: ");
        try {
            Clothes clothes = findClothing(Integer.valueOf(reader.nextLine()));
            System.out.println("Give the Hanger Id plox");
            int hangerId = Integer.valueOf(reader.nextLine());
            for (Clothes element : wardrobe.getCreatedClothes()) {
                for (Hanger element2 : wardrobe.getCreatedHangers()) {
                    element2.addClothToHanger(clothes);
                }
            }
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Clothes findClothing(int clothesId) {
        Clothes clothes = null;
        for (Clothes element : wardrobe.getCreatedClothes()) {
            if (element.getId() == clothesId) {
                clothes = element;
            }
        }
        if (clothes == null) {
        }
        return clothes;
    }

    public Clothes searchClothesById(int clothesId) throws NoSuchIdClothesException {
        Clothes clothes = null;
        for (Clothes element : wardrobe.getCreatedClothes()) {
            if (element.getId() == clothesId) {
                clothes = element;
            }
        }
        if (clothes == null) {
            throw new NoSuchIdClothesException("There is no clothes as id: " + clothesId);
        }
        return clothes;
    }

    public Clothes searchClothesBySize(int size) throws NoSuchSizeClothesException {
        Clothes clothes = null;
        for (Clothes element : wardrobe.getCreatedClothes()) {
            if (element.getSize() == size) {
                clothes = element;
            }
        }
        if (clothes == null) {
            throw new NoSuchSizeClothesException("There is no clothes as size: " + size);
        }
        return clothes;
    }

    public Clothes searchClothesByColor(String color) throws NoSuchColorClothesException {
        Clothes clothes = null;
        for (Clothes element : wardrobe.getCreatedClothes()) {
            if (element.getColor().equals(color)) {
                clothes = element;
            }
        }
        if (clothes == null) {
            throw new NoSuchColorClothesException("There is no clothes as color: " + color);
        }
        return clothes;
    }

    public void addHanger() {
        System.out.println("Give an ID to your hanger: ");
        int hangerId = Integer.valueOf(reader.nextLine());

        System.out.println("Choose a type: ");
        System.out.println(wardrobe.hangerTypeToMap());
        int hangerOption = Integer.valueOf(reader.nextLine());

        wardrobe.createHanger(hangerId, wardrobe.hangerTypeToMap().get(hangerOption));
    }

    public void listHangers() {
        for (Hanger hanger : wardrobe.getCreatedHangers()) {
            System.out.println(hanger.toString());
        }
    }


    public void show(String[] options) {
        System.out.println(" ");
        for (int i = 0; i < options.length - 1; i++) {
            int num = i + 1;
            System.out.println(num + ". " + options[i]);
        }
        System.out.println(0 + ". " + options[options.length - 1]);
    }

    public void addClothes() {

        System.out.println("Give an id to your clothes: ");
        int clothesId = Integer.valueOf(reader.nextLine());

        System.out.println("Give a brand to your clothes: ");
        String brand = reader.nextLine();

        System.out.println("Chose a number: ");
        System.out.println(wardrobe.clothesTypeToMap());
        int option = Integer.valueOf(reader.nextLine());

        System.out.println("Give a color: ");
        String color = reader.nextLine();

        System.out.println("Give a size: ");
        int size = Integer.valueOf(reader.nextLine());

        wardrobe.createClothes(clothesId, brand, wardrobe.clothesTypeToMap().get(option), color, size);

    }

    public void listClothes() {
        for (Clothes element : wardrobe.getCreatedClothes()) {
            System.out.println(element.toString());
        }
    }

}






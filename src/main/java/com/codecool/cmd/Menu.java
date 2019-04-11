package com.codecool.cmd;

import com.codecool.Exceptions.*;
import com.codecool.app.Clothes;
import com.codecool.app.Hanger;
import com.codecool.app.Wardrobe;

import java.util.*;

public class Menu {

    private Scanner reader = new Scanner(System.in);
    private Wardrobe wardrobe;
    private Clothes clothes;

    public Menu() {
        wardrobe = new Wardrobe();
    }

    public void start() {
        String[] options = {"Cloth menu","Hanger menu","Exit"};
        while (true) {
            show(options);
            String chosen = reader.nextLine();
            switch (chosen) {
                case "1": {
                    clothingMenu();
                    break;
                }
                case "2": {
                    hangerMenu();
                    break;
                }
                case "3": {
                    listClothes();
                    break;
                }
                case "0": {
                    System.exit(0);
                }
                default:
                    System.out.println("ERROR!!\nGive me a number pls");
            }
        }
    }

    public void hangerMenu() {
        String[] options = {"Add hanger", "List hangers", "Add clothes to hanger",
            "Remove clothes from hanger","Exit"};
        while (true) {
            show(options);
            String chosen = reader.nextLine();
            switch (chosen) {
                case "1":{
                    addHanger();
                    break;
                }
                case "2": {
                    listHangers();
                    break;
                }
                case "3": {
                    try {
                        addClothingToHanger();
                    } catch (NumberFormatException| NoSuchIdClothesException| NoSuchHangerIdException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case "4":{
                    try {
                        removeClothingFromHanger();
                    }catch (NoSuchIdClothesException|NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "0": {
                    start();
                }
                default:
                    System.out.println("ERROR!!\nGive me a number pls");
            }
        }
    }

    public void clothingMenu(){
        String [] options = {"Add cloth","List Cloth","Find Clothes by ID",
            "Find Clothes by size","Find Clothes by color","Exit"};
        while (true){
            show(options);
            String chosen = reader.nextLine();
            switch (chosen) {
                case "1":{
                    addClothes();
                    break;
                }
                case "2":{
                    listClothes();
                    break;
                }
                case "3":{
                    System.out.println("Give an ID: ");
                    try {
                        int clothesId = Integer.valueOf(reader.nextLine());
                        System.out.println(searchClothesById(clothesId));
                    } catch (NoSuchIdClothesException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                }
                case "4":{
                    System.out.println("Give a size: ");
                    try {
                        int size = Integer.valueOf(reader.nextLine());
                        System.out.println(searchClothesBySize(size).toString());
                    } catch (NoSuchSizeClothesException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case "5":{
                    System.out.println("Give a color: ");
                    try {
                        String color = reader.nextLine();
                        System.out.println(searchClothesByColor(color).toString());
                    } catch (NoSuchColorClothesException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case "0": {
                    start();
                }
                default:
                    System.out.println("ERROR!!\nGive me a number pls");
            }
        }
    }

    public void addClothingToHanger() throws NoSuchHangerIdException, NoSuchIdClothesException {
        System.out.println("Give your clothes ID: ");
        try {
            Clothes clothes = searchClothesById(Integer.valueOf(reader.nextLine()));
            System.out.println("Give the Hanger Id plox");
            int hangerId = Integer.valueOf(reader.nextLine());
            for (Clothes element : wardrobe.getCreatedClothes()) {
                for (Hanger element2 : wardrobe.getCreatedHangers()) {
                    element2.addClothToHanger(clothes);
                }
            }
        } catch (NumberFormatException | NoSuchIdClothesException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void removeClothingFromHanger() throws NoSuchIdClothesException{
        System.out.println("Give the cloth ID: ");
        Clothes clothes = searchClothesById(Integer.valueOf(reader.nextLine()));
        for (Clothes element : wardrobe.getCreatedClothes()){
            for(Hanger element2 : wardrobe.getCreatedHangers()){
                element2.removeClothesFromHanger(clothes);
            }
        }
    }

    public Clothes findClothing(int clothesId) throws NoSuchIdClothesException {
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
        try {
            System.out.println("Give an ID to your hanger: ");
            int hangerId = Integer.valueOf(reader.nextLine());

            System.out.println("Choose a type: ");
            System.out.println(wardrobe.hangerTypeToMap());
            int hangerOption = Integer.valueOf(reader.nextLine());

            wardrobe.createHanger(hangerId, wardrobe.hangerTypeToMap().get(hangerOption));
        }catch (NumberFormatException ex) {
            System.out.println("Only numbers pls!");
        }
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
        try {
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

        }catch (NumberFormatException ex) {
            System.out.println("Only numbers!");
        }


    }

    public void listClothes() {
        for (Clothes element : wardrobe.getCreatedClothes()) {
            System.out.println(element.toString());
        }
    }

}






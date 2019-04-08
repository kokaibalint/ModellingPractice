package com.codecool.cmd;

import com.codecool.app.Clothes;
import com.codecool.app.ClothesType;
import com.codecool.app.Hanger;
import com.codecool.app.Wardrobe;

import java.util.*;

public class Menu {

    private List<ClothesType> enumsToList = List.of(ClothesType.JACKET, ClothesType.TSHIRT, ClothesType.JEANS, ClothesType.SHOES);
    private Scanner reader = new Scanner(System.in);
    private Wardrobe wardrobe;
    private List<Clothes> createdClothes = new ArrayList<>();
    private List<Hanger> hangers = new ArrayList<>();
    private Map<Integer, ClothesType> clothesTypeMap = new HashMap<>();
    private Map<Integer, Clothes> clothesIdMap = new HashMap<>();
    private Map<Object,Object> hangedClothes = new HashMap<>();
    private Hanger hanger;
    private Clothes clothes1;

    public Menu() {
        wardrobe = new Wardrobe();
    }

//    public Wardrobe createWardrobe() {
//        System.out.println("First you need to set a size of your wardrobe!");
//        Wardrobe wardrobe = new Wardrobe(Integer.parseInt(reader.nextLine()));
//        return wardrobe;
//    }

    public void start() {
        String[] options = {"Creating Clothes", "List Clothes", "Search Clothes by color",
            "Search Clothes by size", "Add clothes to hanger", "List Hangers", "Delete Hanger","Exit"};
        while (true) {
            show(options);
            String chosen = reader.nextLine();
            switch (chosen) {
                case "1": {
                    wardrobe.createClothes(clothesIdMap);
                    break;
                }
                case "2": {
                    wardrobe.listClothes(clothesIdMap);
                    break;
                }
                case "3": {
                    wardrobe.searchClothesByColor(createdClothes);
                    break;
                }
                case "4": {
                    wardrobe.searchClothesBySize(createdClothes);
                    break;
                }
                case "5": {
                    wardrobe.createHanger(clothesIdMap,hangedClothes);
                    break;
                }
                case "6": {
                    wardrobe.listHangers(hangedClothes);
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


    private void show(String[] options) {
        System.out.println(" ");
        for (int i = 0; i < options.length - 1; i++) {
            int num = i + 1;
            System.out.println(num + ". " + options[i]);
        }
        System.out.println(0 + ". " + options[options.length - 1]);
    }
    }






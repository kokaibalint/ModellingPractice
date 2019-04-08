package com.codecool.app;

import com.codecool.cmd.ClothesIsDirtyException;
import com.codecool.cmd.NoSuchHangerIdException;

import java.util.*;

public class Wardrobe {

    private List<ClothesType> enumsToList = List.of(ClothesType.JACKET, ClothesType.TSHIRT, ClothesType.JEANS, ClothesType.SHOES);
    private Scanner reader = new Scanner(System.in);
    private List<Clothes> createdClothes = new ArrayList<>();
    private List<Hanger> hangers = new ArrayList<>();
    private Map<Integer, ClothesType> clothesTypeMap = new HashMap<>();
    private Hanger hanger;
    private Clothes clothes1;

    public Wardrobe() {
    }
    public void createClothes(Map<Integer,Clothes> clothesIdMap) {

        for (int i = 0; i < enumsToList.size(); i++) {
            clothesTypeMap.put(i, enumsToList.get(i));
        }

        try {

            System.out.println("Give an id to your clothes: ");
            int clothesId = Integer.valueOf(reader.nextLine());

            System.out.println("Give a brand to your clothes: ");
            String brand = reader.nextLine();

            System.out.println("Chose a number: ");
            System.out.println(clothesTypeMap);
            int option = Integer.valueOf(reader.nextLine());

            System.out.println("Give a color: ");
            String color = reader.nextLine();

            System.out.println("Give a size: ");
            int size = Integer.valueOf(reader.nextLine());

            System.out.println("Is it clean?");
            System.out.println("1.Yes / 2.No");
            int cleanNumber = Integer.valueOf(reader.nextLine());


            if (cleanNumber == 1) {
                Clothes clothes1 = new Clothes(clothesId, brand, clothesTypeMap.get(option), color, size, false, true, true);
                createdClothes.add(clothes1);
                clothesIdMap.put(clothesId, clothes1);

            } else {
                Clothes clothes1 = new Clothes(clothesId, brand, clothesTypeMap.get(option), color, size, false, true, false);
                throw new ClothesIsDirtyException("The clothes is dirty, u cant put it into the wardrobe!");
            }
        } catch (ClothesIsDirtyException | NumberFormatException ex) {
            System.out.println(ex.getMessage() + "\n");
            System.out.println("Give me a number pls!");
        }

    }
    public void listClothes(Map<Integer,Clothes> clothesIdMap) {
        System.out.println(clothesIdMap);
    }

    public void searchClothesByColor(List<Clothes> createdClothes) {
        System.out.println("Give me a color: ");
        try {
            String color = reader.nextLine();

            for (int i = 0; i < createdClothes.size(); i++) {
                if (color.equals(createdClothes.get(i).getColor())) {
                    System.out.println(createdClothes.get(i));
                }
                else {
                    System.out.println("There is no such Clothes!");
                }

            }
        }catch (NumberFormatException ex) {
            System.out.println("Give me a number pls!");
        }
    }

    public void searchClothesBySize(List<Clothes> createdClothes){
        System.out.println("Give me a size: ");
        try {

            int size = Integer.valueOf(reader.nextLine());

            for (int i = 0; i < createdClothes.size(); i++) {
                if (size == createdClothes.get(i).getSize()) {
                    System.out.println(createdClothes.get(i));
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Give me a number ty!");
        }
    }

    public void createHanger(Map<Integer,Clothes> clothesIdMap,Map<Object,Object> hangedClothes) {

        System.out.println("Give the clothes ID which you want to add to a hanger: ");

        try {

            int clothesId = Integer.valueOf(reader.nextLine());


            if (clothesIdMap.containsKey(clothesId)) {

                System.out.println("Give an id to your hanger: ");
                int hangerId = Integer.valueOf(reader.nextLine());


                clothesIdMap.get(clothesId).setHanged(true);
                clothesIdMap.get(clothesId).setOnTheFloor(false);

                Map<Integer,Hanger> hangerMap = new HashMap<>();
                hangerMap.put(hangerId,new Hanger(hangerId));

                hangedClothes.put(clothesIdMap, hangerMap);

                System.out.println(hangedClothes);


            } else {
                System.out.println("There is no such clothes ID! Try again!");

            }


        } catch (NumberFormatException ex) {
            System.out.println("Not number lol");
        }
    }

    public void listHangers(Map<Object,Object> hangedClothes) {
        if(hangedClothes.size() == 0) {
            System.out.println("Its empty my dude!");
        }
        else {
            System.out.println(hangedClothes);
        }
    }
}

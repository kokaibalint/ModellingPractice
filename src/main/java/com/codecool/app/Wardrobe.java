package com.codecool.app;

import java.util.*;

public class Wardrobe {

    private List<ClothesType> enumsToList = List.of(ClothesType.TOP, ClothesType.BOTTOM);
    private Map<Integer, ClothesType> clothesTypeMap = new HashMap<>();

    private Hanger hanger;
    private Clothes clothes;

    private List<Clothes> createdClothes;
    private List<Hanger> createdHangers;

    public Wardrobe() {
        this.createdClothes = new ArrayList<>();
        this.createdHangers = new ArrayList<>();
    }

public Clothes createClothes(int clothesId,String brand,ClothesType clothesType,String color,int size) {
        Clothes clothes = new Clothes(clothesId, brand, clothesType, color, size, false, true, true);
        createClothesList(clothes);
        return clothes;
    }
    public List<Clothes> createClothesList(Clothes clothes) {
        createdClothes.add(clothes);
        return createdClothes;
    }
    public Map<Integer,ClothesType> clothesTypeToMap() {
        for (int i = 0; i < enumsToList.size(); i++) {
            clothesTypeMap.put(i, enumsToList.get(i));
        }
        return clothesTypeMap;
    }
    public Hanger createHanger(int hangerId) {
        Hanger hanger = new Hanger(hangerId);
        createHangerList(hanger);
        return hanger;

    }

    private List<Hanger> createHangerList(Hanger hanger) {
        createdHangers.add(hanger);
        return createdHangers;
    }
//
//    }
//
//
//    public void searchClothesByColor(List<Clothes> createdClothes) {
//        System.out.println("Give me a color: ");
//        try {
//            String color = reader.nextLine();
//
//            for (int i = 0; i < createdClothes.size(); i++) {
//                if (color.equals(createdClothes.get(i).getColor())) {
//                    System.out.println(createdClothes.get(i));
//                }
//                else {
//                    System.out.println("There is no such Clothes!");
//                }
//
//            }
//        }catch (NumberFormatException ex) {
//            System.out.println("Give me a number pls!");
//        }
//    }
//
//    public void searchClothesBySize(List<Clothes> createdClothes){
//        System.out.println("Give me a size: ");
//        try {
//
//            int size = Integer.valueOf(reader.nextLine());
//
//            for (int i = 0; i < createdClothes.size(); i++) {
//                if (size == createdClothes.get(i).getSize()) {
//                    System.out.println(createdClothes.get(i));
//                }
//            }
//        } catch (NumberFormatException nfe) {
//            System.out.println("Give me a number ty!");
//        }
//    }
//
//    public void createHanger(Map<Integer,Clothes> clothesIdMap,Map<Object,Object> hangedClothes) {
//
//        System.out.println("Give the clothes ID which you want to add to a hanger: ");
//
//        try {
//
//            int clothesId = Integer.valueOf(reader.nextLine());
//
//
//            if (clothesIdMap.containsKey(clothesId)) {
//
//                System.out.println("Give an id to your hanger: ");
//                int hangerId = Integer.valueOf(reader.nextLine());
//
//
//                clothesIdMap.get(clothesId).setHanged(true);
//                clothesIdMap.get(clothesId).setOnTheFloor(false);
//
//                Map<Integer,Hanger> hangerMap = new HashMap<>();
//                hangerMap.put(hangerId,new Hanger(hangerId));
//
//                hangedClothes.put(clothesIdMap, hangerMap);
//
//                System.out.println(hangedClothes);
//
//
//            } else {
//                System.out.println("There is no such clothes ID! Try again!");
//
//            }
//
//
//        } catch (NumberFormatException ex) {
//            System.out.println("Not number lol");
//        }
//    }
//
//    public void listHangers(Map<Object,Object> hangedClothes) {
//        if(hangedClothes.size() == 0) {
//            System.out.println("Its empty my dude!");
//        }
//        else {
//            System.out.println(hangedClothes);
//        }
//    }


    public List<Clothes> getCreatedClothes() {
        return createdClothes;
    }

    public List<Hanger> getCreatedHangers() {
        return createdHangers;
    }
}

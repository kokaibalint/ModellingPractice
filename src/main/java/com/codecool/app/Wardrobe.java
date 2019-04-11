package com.codecool.app;

import com.codecool.Exceptions.NoSuchIdClothesException;
import com.codecool.cmd.Menu;

import java.util.*;

public class Wardrobe {

    private List<ClothesType> clothesTypesToList = List.of(ClothesType.TOP, ClothesType.BOTTOM);
    private List<HangerType> hangerTypesToList = List.of(HangerType.SINGLE, HangerType.DOUBLE, HangerType.SKIRT);
    private Map<Integer, ClothesType> clothesTypeMap = new HashMap<>();
    private Map<Integer, HangerType> hangerTypeMap = new HashMap<>();
    private Map<Hanger, Clothes> hangedClothes = new HashMap<>();

    private List<Clothes> createdClothes;
    private List<Hanger> createdHangers;

    public Wardrobe() {
        this.createdClothes = new ArrayList<>();
        this.createdHangers = new ArrayList<>();
    }

    public Clothes createClothes(int clothesId, String brand, ClothesType clothesType, String color, int size) {
        Clothes clothes = new Clothes(clothesId, brand, clothesType, color, size, false,true);
        createClothesList(clothes);
        return clothes;
    }

    public List<Clothes> createClothesList(Clothes clothes) {
        createdClothes.add(clothes);
        return createdClothes;
    }

    public Map<Integer, ClothesType> clothesTypeToMap() {
        for (int i = 0; i < clothesTypesToList.size(); i++) {
            clothesTypeMap.put(i, clothesTypesToList.get(i));
        }
        return clothesTypeMap;
    }

    public Map<Integer, HangerType> hangerTypeToMap() {
        for (int i = 0; i < hangerTypesToList.size(); i++) {
            hangerTypeMap.put(i, hangerTypesToList.get(i));
        }
        return hangerTypeMap;
    }

    public Hanger createHanger(int hangerId, HangerType hangerType) {
        Hanger hanger = new Hanger(hangerId, hangerType);
        createHangerList(hanger);
        return hanger;
    }

    private List<Hanger> createHangerList(Hanger hanger) {
        createdHangers.add(hanger);
        return createdHangers;
    }

    public List<Clothes> getCreatedClothes() {
        return createdClothes;
    }

    public List<Hanger> getCreatedHangers() {
        return createdHangers;
    }

//    public void addClothesToHanger(int clothesId, int hangerId) throws NoSuchIdClothesException {
//        Clothes clothes = menu.searchClothesById(clothesId);
//        Hanger hanger = menu.
//
//    }
}


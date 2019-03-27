package com.codecool.cmd;

import com.codecool.app.Clothes;
import com.codecool.app.ClothesType;
import com.codecool.app.Hanger;
import com.codecool.app.Wardrobe;

import java.util.*;

public class Menu {

    private List<ClothesType> enumsToList = List.of(ClothesType.JACKET,ClothesType.TSHIRT,ClothesType.JEANS,ClothesType.SHOES);
    private Scanner reader = new Scanner(System.in);
    private Wardrobe wardrobe;
    private List<Clothes> createdClothes = new ArrayList<>();
    private Map<Integer,ClothesType> clothesTypeMap = new HashMap<>();
    private Map<Integer,Clothes> clothesIdMap = new HashMap<>();
    private Map<Integer,Hanger> hangerIdMap = new HashMap<>();
    private Clothes clothes1;

    public Menu() {
//        wardrobe = createWardrobe();
    }

//    public Wardrobe createWardrobe() {
//        System.out.println("First you need to set a size of your wardrobe!");
//        Wardrobe wardrobe = new Wardrobe(Integer.parseInt(reader.nextLine()));
//        return wardrobe;
//    }

    public void start () {
        String [] options = {"Clothing menu","Listing menu", "Hanger menu"};
        while(true) {
            show(options);
        String chosen = reader.nextLine();
            switch (chosen) {
                case "1": {
                    createClothes();
                    break;
                }
                case "2": {
                    listClothes();
                    break;
                }
                case "3": {
                    createHanger();
                }
                case "0": {
                    System.exit(0);
                }
            }
        }

    }


    private void show(String[] options) {
        System.out.println(" ");
        for (int i = 0; i < options.length - 1; i++) {
            int num = i + 1;
            System.out.println(num + ". " + options[i]);
        }
        System.out.println(0 + ". " + options[options.length-1]);
    }

    public void createClothes() {

        for(int i = 0; i < enumsToList.size() ; i++) {
            clothesTypeMap.put(i,enumsToList.get(i));
        }

        System.out.println("Give an id to your clothes: ");
        int clothesId = Integer.valueOf(reader.nextLine());

        System.out.println("Give a brand to your clothes: ");
        String brand = reader.nextLine();

        System.out.println("Chose a number: ");
        System.out.println(clothesTypeMap);
        int option = Integer.valueOf(reader.nextLine());

        System.out.println("Is it clean?");
        System.out.println("1.Yes / 2.No");
        int cleanNumber = Integer.valueOf(reader.nextLine());

        try {

        if (cleanNumber == 1) {
            Clothes clothes1 = new Clothes(clothesId,brand,clothesTypeMap.get(option),false, false,true);
            createdClothes.add(clothes1);

        }else {
            Clothes clothes1 = new Clothes(clothesId,brand,clothesTypeMap.get(option),false, false,false);
            throw new ClothesIsDirtyException("The clothes is dirty, u cant put it into the wardrobe");
        }
        clothesIdMap.put(clothesId,clothes1);
        }
        catch (ClothesIsDirtyException ex) {
            System.out.println(ex.getMessage());
        }

    }
    public void listClothes() {
        System.out.println(createdClothes);
    }

    private void createHanger() {
        System.out.println("Give an id to your hanger: ");
        int hangerId = Integer.valueOf(reader.nextLine());

        Hanger hanger = new Hanger(hangerId);
        hangerIdMap.put(hangerId,hanger);
    }

    private void listHangers() {
        System.out.println(hangerIdMap);
    }



    // legyen eltárolva a földön a ruha és a wardrobeba beletudja rakni a szekrénybe(legyen a ruhának ID-ja)
    // Vállfákat lehessen létrehozni (hanger száma maximalizált, és hány ruha fér rá)
    // letörölni válfát ha van rajta ruha ne lehessen.
    // szennyes ruha (ha nem tiszta hanem koszos akkor nem lehet berakni, megpróbálhatja de exceptiont dob)
    //szín és méret alapján keresni



}

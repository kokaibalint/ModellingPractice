package com.codecool.cmd;

import com.codecool.app.Clothes;
import com.codecool.app.ClothesType;
import com.codecool.app.Wardrobe;

import java.util.*;

public class Menu {

    private List<ClothesType> enumsToList = List.of(ClothesType.JACKET,ClothesType.TSHIRT,ClothesType.JEANS,ClothesType.SHOES);
    private Scanner reader = new Scanner(System.in);
    private Wardrobe wardrobe;
    private List<Clothes> createdClothes = new ArrayList<>();
    private Map<Integer,ClothesType> clothesTypeMap = new HashMap<>();
    private Map<Integer,Clothes> clothesId = new HashMap<>();

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
        int id = Integer.valueOf(reader.nextLine());

        System.out.println("Give a brand to your clothes: ");
        String brand = reader.nextLine();

        System.out.println("Chose a number: ");
//        clothesTypeMap = clothesTypeA();
        System.out.println(clothesTypeMap);
        int option = Integer.valueOf(reader.nextLine());

        Clothes clothes1 = new Clothes(id,brand,clothesTypeMap.get(option));
        createdClothes.add(clothes1);
        clothesId.put(id,clothes1);
    }
    public void listClothes() {
        System.out.println(createdClothes);
    }




    // legyen eltárolva a földön a ruha és a wardrobeba beletudja rakni a szekrénybe(legyen a ruhának ID-ja)
    // Vállfákat lehessen létrehozni (hanger száma maximalizált, és hány ruha fér rá)
    // letörölni válfát ha van rajta ruha ne lehessen.
    // szennyes ruha (ha nem tiszta hanem koszos akkor nem lehet berakni, megpróbálhatja de exceptiont dob)
    //szín és méret alapján keresni



}

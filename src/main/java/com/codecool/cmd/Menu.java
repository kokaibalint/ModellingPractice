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
    private Map<Integer, Hanger> hangerIdMap = new HashMap<>();
    private Hanger hanger;
    private Clothes clothes1;

    public Menu() {
//        wardrobe = createWardrobe();
    }

//    public Wardrobe createWardrobe() {
//        System.out.println("First you need to set a size of your wardrobe!");
//        Wardrobe wardrobe = new Wardrobe(Integer.parseInt(reader.nextLine()));
//        return wardrobe;
//    }

    public void start() {
        String[] options = {"Creating Clothes", "List Clothes", "Search Clothes by color",
            "Search Clothes by size", "Create Hanger", "List Hangers", "Delete Hanger","Add clothes to hanger","Exit"};
        while (true) {
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
                    searchClothesByColor(createdClothes);
                    break;
                }
                case "4": {
                    searchClothesBySize(createdClothes);
                    break;
                }
                case "5": {
                    createHanger();
                    break;
                }
                case "6": {
                    listHangers();
                    break;
                }
                case "7": {
                    delHanger(hanger);
                    break;
                }
                case "8": {
                    addClothesToHanger(hangerIdMap,clothesIdMap);
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
        System.out.println(0 + ". " + options[options.length - 1]);
    }

    public void createClothes() {

        for (int i = 0; i < enumsToList.size(); i++) {
            clothesTypeMap.put(i, enumsToList.get(i));
        }

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

        try {

            if (cleanNumber == 1) {
                Clothes clothes1 = new Clothes(clothesId, brand, clothesTypeMap.get(option), color, size, false, false, true);
                createdClothes.add(clothes1);
                clothesIdMap.put(clothesId, clothes1);

            } else {
                Clothes clothes1 = new Clothes(clothesId, brand, clothesTypeMap.get(option), color, size, false, false, false);
                throw new ClothesIsDirtyException("The clothes is dirty, u cant put it into the wardrobe!");
            }
        } catch (ClothesIsDirtyException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void listClothes() {
        System.out.println(createdClothes);
    }

    public void searchClothesByColor(List<Clothes> createdClothes) {
        System.out.println("Give me a color: ");
        String color = reader.nextLine();

        for (int i = 0; i < createdClothes.size(); i++) {
            if (color.equals(createdClothes.get(i).getColor())) {
                System.out.println(createdClothes.get(i));
            }
        }
    }

    public void searchClothesBySize(List<Clothes> createdClothes) {
        System.out.println("Give me a size: ");
        int size = Integer.valueOf(reader.nextLine());

        for (int i = 0; i < createdClothes.size(); i++) {
            if (size == createdClothes.get(i).getSize()) {
                System.out.println(createdClothes.get(i));
            }
        }
    }

    public Hanger createHanger() {
        System.out.println("Give an id to your hanger: ");
        int hangerId = Integer.valueOf(reader.nextLine());


        Hanger hanger = new Hanger(hangerId);
        hangerIdMap.put(hangerId, hanger);
        try {
            if (hangers.size() < 3) {
                hangers.add(hanger);
            } else {
                throw new TooBigHangerSizeException("You cant make that much hanger!");
            }
        } catch (TooBigHangerSizeException e) {
            System.out.println(e.getMessage());
        }
        return hanger;
    }


    public void listHangers() {
        System.out.println(hangerIdMap);
    }

    public void delHanger(Hanger hanger) {
        System.out.println("Enter a hanger id that you want to delete: ");
        int delHangerId = Integer.valueOf(reader.nextLine());

        try {
            if (hangerIdMap.containsKey(delHangerId)) {
                hangerIdMap.remove(hanger);
            } else {
                throw new NoSuchHangerIdException("There is no such Hange ID");
            }

        } catch (NoSuchHangerIdException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addClothesToHanger(Map<Integer, Hanger> hangerIdMap, Map<Integer, Clothes> clothesIdMap) {
//        int hangerId = Integer.valueOf(reader.nextLine());
//        int clothesId = Integer.valueOf(reader.nextLine());
//        for (int i = 0; i < hangerIdMap.size(); i++) {
//            for (int j = 0; j < clothesIdMap.size();j++) {
//                if (hangerIdMap.containsKey(hangerId) && clothesIdMap.containsKey(clothesId)) {
//                    clothesIdMap.get(j).setHanged(true);
//                    Map<Hanger, Integer> hangedClothes = new HashMap<>();
//                    hangedClothes.put(hanger, j); //belekéne rakni a settelt clothes-t egy hashmapbbe
//                    System.out.println(hangedClothes);
//                }
//            }
        System.out.println("in Pogress");
        }
    }



// legyen eltárolva a földön a ruha és a wardrobeba beletudja rakni a szekrénybe(legyen a ruhának ID-ja) |PIPA|
// Vállfákat lehessen létrehozni (hanger száma maximalizált, és hány ruha fér rá) |PIPA|
// letörölni válfát ha van rajta ruha ne lehessen.
// szennyes ruha (ha nem tiszta hanem koszos akkor nem lehet berakni, megpróbálhatja de exceptiont dob)|PIPA|
//szín és méret alapján keresni




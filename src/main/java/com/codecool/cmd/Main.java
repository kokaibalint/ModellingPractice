// java -cp target/JAR-1.0-SNAPSHOT.jar com.codecool.cmd.Main

package com.codecool.cmd;

import com.codecool.app.Clothes;
import com.codecool.app.ClothesType;
import com.codecool.app.Hanger;
import com.codecool.app.Wardrobe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        Scanner input = new Scanner(System.in);
//        System.out.println("Do you want to get a hanger into your wardrobe? y/n");
//        String makeHanger = input.nextLine();

//        Wardrobe wardrobe = new Wardrobe();
//        wardrobe.wardrobeAddHanger(makeHanger);


//        System.out.println("1 - Jacket, " +
//                            "2 - Jeans, " +
//                            "3 - T-Shirt, " +
//                            "4 - Shoes");
//
//        Scanner reader = new Scanner(System.in);
//        System.out.println("What clothes do you want to hang on?");
//        String userClothes = reader.nextLine();



//        hanging.hangerAddClothes(userClothes);
        Hanger hanging = new Hanger();

        Scanner userInput = new Scanner(System.in);

        for (int i = 0; i < userInput;i++)
        System.out.println("Whats your clothes color: ");
        String clothesColorByUser = userInput.nextLine();
        System.out.println("Whats your clothes brand: ");
        String clothesBrandByUser = userInput.nextLine();
        System.out.println("Whats your clothes type: ");
        String clothesTypeByUser = userInput.nextLine();
        ClothesType a = ClothesType.valueOf(clothesTypeByUser);

        List<String> clothes1 = new ArrayList<>();
        clothes1.add(clothesColorByUser);
        clothes1.add(clothesBrandByUser);
        clothes1.add(clothesTypeByUser);

        System.out.println(clothes1);



//        Clothes clothes1 = new Clothes(clothesColorByUser,clothesBrandByUser,a);

//        hanging.makeClothes(userInput);






    }
}

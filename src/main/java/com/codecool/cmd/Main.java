// java -cp target/JAR-1.0-SNAPSHOT.jar com.codecool.cmd.Main

package com.codecool.cmd;

import com.codecool.app.Hanger;
import com.codecool.app.Wardrobe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to get a hanger into your wardrobe? y/n");
        String makeHanger = input.next();

        Wardrobe wardrobe = new Wardrobe();
        wardrobe.wardrobeAddHanger(makeHanger);


        System.out.println("1 - Jacket, " +
                            "2 - Jeans, " +
                            "3 - T-Shirt, " +
                            "4 - Shoes");

        Scanner reader = new Scanner(System.in);
        System.out.println("What clothes do you want to hang on?");
        String userClothes = reader.next();



        Hanger hanging = new Hanger(1);
        hanging.hangerAddClothes(userClothes);




    }
}

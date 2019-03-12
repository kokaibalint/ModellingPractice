// java -cp target/JAR-1.0-SNAPSHOT.jar com.codecool.cmd.Main

package com.codecool.cmd;

import com.codecool.app.Hanger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("1 - Jacket, " +
                            "2 - Jeans, " +
                            "3 - T-Shirt, " +
                            "4 - Shoes");

        Scanner reader = new Scanner(System.in);
        System.out.println("What clothes do you want to hang on?");
        String userClothes = reader.next();

        Hanger hanging = new Hanger();
        hanging.hangerAddClothes(userClothes);




    }
}

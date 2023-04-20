package csc251.team.project;
// Group 5
// GroupProject.Main.java is the main code for executing commands related to car.java
// and CarLot.java

// 06 JULY 2022
// CSC.151.0001

//package GroupProject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // VVV these are just examples. I assume we will use a
        // scanner to input data for each vehicle

        Car a = new Car("ford f150 1995", 256788,
                16, 8500, 13000,
                14999.99, false);

        System.out.println("ID: " + a.getId());
        System.out.println("Mileage: " + a.getMileage() + " Miles");
        System.out.println("MPG: " + a.getMpg());
        System.out.println("Cost: $" + a.getCost());
        System.out.println("Asking Price: $" + a.getAskingPrice());
        System.out.println("Sales Price: $" + a.getSalePrice());
        System.out.println("Is sold: " + a.getIsSold());

    }
}

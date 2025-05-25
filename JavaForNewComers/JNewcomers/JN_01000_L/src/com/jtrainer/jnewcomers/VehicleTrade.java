package com.jtrainer.jnewcomers;

import java.util.Scanner;

public class VehicleTrade {
    public static void main(String[] args) {
        new VehicleTrade().run();
    }

    private void run() {
        System.out.println("Welcome to the vehicle trade!");
        int selection;

        do {
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println("1) List vehicle categories");
            System.out.println("2) Search used vehicle");
            System.out.println("3) Credit advice");
            System.out.println(("9) Exit"));

            Scanner scanner = new Scanner(System.in);
            selection = scanner.nextInt();

            if (selection == 9) { break; }

            if (selection == 1) {
                System.out.println("We trade in the following vehicle categories:");
                System.out.println("Limousine");
                System.out.println("EstateCar");
                System.out.println("Cabriolet");
                System.out.println("SportsCar");
            }

            if (selection == 2) {
                System.out.println("Which vehicle category are you looking for?");
                String vehicleCategory = scanner.next();
                if (vehicleCategory.equalsIgnoreCase("SportsCar")
                    || vehicleCategory.equalsIgnoreCase("Cabriolet")) {
                    System.out.println("At the moment we have no used sports cars on offer.");
                } else if (vehicleCategory.equalsIgnoreCase("Limousine")
                    || vehicleCategory.equalsIgnoreCase("EstateCar")) {
                    System.out.println("All right, we are looking for used vehicles of the desired category "
                            + vehicleCategory + ".");
                } else {
                    System.out.println("Unknown vehicle category: " + vehicleCategory);
                }
            }

            if (selection == 3) {
                System.out.println("How expensive is the vehicle you want to finance?");
                int vehiclePrice = scanner.nextInt();
                System.out.println("How many months would you like to finance the vehicle for?");
                int numberOfMonthlyPayments = scanner.nextInt();

                if (numberOfMonthlyPayments > 0
                    && numberOfMonthlyPayments % 12 == 0) {
                    double monthlyPayment = (vehiclePrice * 1.03 + 20.0) / numberOfMonthlyPayments - 1;
                    System.out.println("Please pay " + numberOfMonthlyPayments
                            + " monthly payments of $" + monthlyPayment);
                } else {
                    System.out.println("Sorry, we cannot offer this financing.");
                }
            }
        } while(selection != 9);

        System.out.println("Bye and visit us again soon.");
    }
}

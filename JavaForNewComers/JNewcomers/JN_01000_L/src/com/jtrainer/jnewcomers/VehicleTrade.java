package com.jtrainer.jnewcomers;

import java.util.Scanner;

public class VehicleTrade {

    private Vehicle[] vehicles;

    public static void main(String[] args) {
        new VehicleTrade().run();
    }

    private void run() {
        createVehicles();

        System.out.println("Welcome to the vehicle trade!");

        int selection;
        do {
            printMenu();

            Scanner scanner = new Scanner(System.in);
            selection = scanner.nextInt();

            if (selection == 1) {
                listVehicleCategories();
            }

            if (selection == 2) {
                String vehicleCategory = selectVehicleCategory(scanner);

                Vehicle vehicle = selectVehicle(scanner, vehicleCategory);

                sellVehicle(vehicle);
            }

            if (selection == 3) {
                creditAdvice(scanner, 1.03);
            }
        } while (selection != 9);

        System.out.println("Bye and visit us again soon.");
    }

    private void createVehicles() {
        vehicles = new Vehicle[] {
                new Vehicle("VW", "Golf VI Variant", "silver", 150,
                        "08/2022", 30_000, 19_500),
                new Vehicle("Audi", "A6 Avant", "deep blue", 200,
                        "06/2021", 56_500, 39_900),
                new Vehicle("BMW", "525d Touring AT", "black", 245,
                        "05/2020", 75_000, 29_800),
                new Vehicle("MB", "E220d", "silver", 200,
                        "11/2019", 90_500, 27_900),
                new Vehicle("Opel", "Astra 1.6i", "gray", 110,
                        "03/2023", 1_250, 23_500)
        };
    }

    private void printMenu() {
        System.out.println();
        System.out.println("What do you want to do?");
        System.out.println("1) List vehicle categories");
        System.out.println("2) Search used vehicle");
        System.out.println("3) Credit advice");
        System.out.println("9) Exit");
    }

    private void listVehicleCategories() {
        System.out.println("We trade in the following vehicle categories:");
        System.out.println("Limousine");
        System.out.println("EstateCar");
        System.out.println("Cabriolet");
        System.out.println("SportsCar");
    }

    private String selectVehicleCategory(Scanner scanner) {
        boolean vehicleCategoryAvailable = false;
        String vehicleCategory;
        do {
            System.out.println("Which vehicle category are you looking for?");
            vehicleCategory = scanner.next();
            if (vehicleCategory.equalsIgnoreCase("SportsCar")
                    || vehicleCategory.equalsIgnoreCase("Cabriolet")) {
                System.out.println("At the moment we have no used vehicles of the category \""
                        + vehicleCategory + "\" on offer.");
            } else if (vehicleCategory.equalsIgnoreCase("Limousine")
                    || vehicleCategory.equalsIgnoreCase("EstateCar")) {
                System.out.println("All right, we are looking for used vehicles of the category \""
                        + vehicleCategory + "\".");
                vehicleCategoryAvailable = true;
            } else {
                System.out.println("Unknown vehicle category: \"" + vehicleCategory + "\"");
            }
        } while (!vehicleCategoryAvailable);
        return vehicleCategory;
    }

    private Vehicle selectVehicle(Scanner scanner, String vehicleCategory) {
        System.out.println("We have the following vehicles of the category \"" + vehicleCategory + "\" on offer:");

        for (int i = 0; i < vehicles.length; i++) {
            System.out.println((i + 1) + ") " + vehicles[i]);
        }

        System.out.println("Which vehicle do you want to buy?");
        int vehicleNumber = scanner.nextInt();

        int index = vehicleNumber - 1;
        if (index < 0 || index >= vehicles.length) {
            return null;
        }
        return vehicles[index];
    }

    private boolean creditAdvice(Scanner scanner, double interestFactor) {
        System.out.println("How expensive is the vehicle you want to finance?");
        int vehiclePrice = scanner.nextInt();
        System.out.println("How many months would you like to finance the vehicle for?");
        int numberOfMonthlyPayments = scanner.nextInt();
        boolean creditApplicationAccepted;
        if (numberOfMonthlyPayments > 0 && numberOfMonthlyPayments % 12 == 0) {
            double monthlyPayment = (vehiclePrice * interestFactor + 20.0) / numberOfMonthlyPayments - 1;
            System.out.printf("Please pay %d monthly payments of $%.2f%n", numberOfMonthlyPayments, monthlyPayment);
            creditApplicationAccepted = true;
        } else {
            System.out.println("Sorry, we cannot offer this financing.");
            creditApplicationAccepted = false;
        }
        return creditApplicationAccepted;
    }

    private void sellVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            System.out.println("Too bad, maybe another time there is a vehicle for you.");
        } else if (vehicle.isSold()) {
            System.out.println("Sorry, the vehicle is already sold, someone else was quicker than you!");
        } else {
            System.out.println("Please pay the purchase price in the amount of $"
                    + vehicle.getPrice() + " to our account.");
            System.out.println("Congratulations, you have bought vehicle \"" + vehicle + "\".");
            if (vehicle.hasPopularColor()) {
                System.out.println("Your vehicle has a popular color.");
            }
            vehicle.setSold(true);
        }
    }
}

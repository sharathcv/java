package com.jtrainer.jnewcomers;

import java.util.Scanner;

public class VehicleTrade {
    public static void main(String[] args) {
        new VehicleTrade().run();
    }

    private void run() {
        System.out.println("Welcome to the vehicle trade!");
        System.out.println("What do you want to do?");
        System.out.println("1) List vehicle categories");
        System.out.println("2) Search used vehicle");
        System.out.println("3) Credit advice");

        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();

        if (selection == 1) {
            System.out.println("We trade in the following vehicle categories:");
            System.out.println("Limousine");
            System.out.println("EstateCar");
            System.out.println("Cabriolet");
            System.out.println("SportsCar");
        }

        if (selection == 2) {
            System.out.println("At the moment we have no used vehicles on offer.");
        }

        if (selection == 3) {
            System.out.println("How expensive is the vehicle you want to finance?");
            int vehiclePrice = scanner.nextInt();
            System.out.println("How many months would you like to finance the vehicle for?");
            int numberOfMonthlyPayments = scanner.nextInt();
            double monthlyPayment = (vehiclePrice * 1.03 + 20.0) / numberOfMonthlyPayments - 1;
            System.out.println("Monthly payment");
            System.out.println(monthlyPayment);
        } 
    }
}

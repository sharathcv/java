package com.jtrainer.jnewcomers;

public class Vehicle {
    private static int numberDiscountedVehicles = 0;

    private String manufacturer;
    private String model;
    private String color;
    private int horsepower;
    private String yearOfManufacture;
    private int miles;
    private int price;
    private Double discountInPercent;
    private boolean sold;

    public static boolean hasDiscountedVehicles() {
        return numberDiscountedVehicles > 0;
    }

    public Vehicle(String manufacturer, String model, String color, int horsepower, String yearOfManufacture,
                   int miles, int price, Double discountInPercent) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
        this.yearOfManufacture = yearOfManufacture;
        this.miles = miles;
        this.price = price;
        setDiscountInPercent(discountInPercent);
        this.sold = false;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Double getDiscountInPercent() {
        return discountInPercent;
    }

    public void setDiscountInPercent(Double discountInPercent) {
        if (this.discountInPercent == null && discountInPercent != null) {
            numberDiscountedVehicles++;
        }
        if (this.discountInPercent != null && discountInPercent == null) {
            numberDiscountedVehicles--;
        }
        this.discountInPercent = discountInPercent;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public String toString() {
        String result = manufacturer + " " + model + " " + color + " " + horsepower + "hp year built "
                + yearOfManufacture + " " + miles + " miles $" + price;
        if (discountInPercent != null) {
            result = result + " minus " + discountInPercent + "% discount";
        }
        if (isSold()) {
            result = result + " SOLD";
        }
        return result;
    }

    public boolean hasPopularColor() {
        return "gray".equalsIgnoreCase(color) || "black".equalsIgnoreCase(color) || "white".equalsIgnoreCase(color);
    }

    public int calculateDiscountPrice() {
        if (discountInPercent != null) {
            double percentageFactor = discountInPercent / 100.0;
            int discountInDollar = (int) (price * percentageFactor);
            return price - discountInDollar;
        } else {
            return price;
        }
    }
}

package com.epam.automation.collections.mainTask.candies;

abstract class Candy {
    private String name;
    private String manufacturer;
    private double weight;

    String getName() {
        return name;
    }

    String getManufacturer() {
        return manufacturer;
    }


    public double getWeight() {
        return weight;
    }

    Candy() {
    }

    Candy(String name) {
        this.name = name;
    }

    Candy(String name, String manufacturer, double weight) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    public abstract double sugarContain();

}

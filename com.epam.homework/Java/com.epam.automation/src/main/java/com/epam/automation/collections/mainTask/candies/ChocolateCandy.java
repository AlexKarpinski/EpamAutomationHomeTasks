package com.epam.automation.collections.mainTask.candies;

public class ChocolateCandy extends Candy {
    @Override
    public double sugarContain() {
        return getWeight()*0.9;
    }

    public ChocolateCandy() {
    }

    public ChocolateCandy(String name) {
        super(name);
    }

    public ChocolateCandy(String name, String manufacturer, double weight) {
        super(name, manufacturer, weight);
    }
    @Override
    public String toString() {
        return "\nChocolateCandy{" +
                "name='" + getName() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", weight=" + getWeight() +
                ", sugarContain='" + sugarContain()+
                '}';
    }
}

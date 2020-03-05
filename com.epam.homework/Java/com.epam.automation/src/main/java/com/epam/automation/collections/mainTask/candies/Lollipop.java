package com.epam.automation.collections.mainTask.candies;

public class Lollipop extends Candy {
    @Override
    public double sugarContain() {
        return getWeight() *0.9 ;
    }

    public Lollipop() {
    }

    public Lollipop(String name) {
        super(name);
    }

    public Lollipop(String name, String manufacturer, double weight) {
        super(name, manufacturer, weight);
    }
    @Override
    public String toString() {
        return "\nLollipop{" +
                "name='" + getName() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", weight=" + getWeight() +
                ", sugarContain='" + sugarContain()+
                '}';
    }
}

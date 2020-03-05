package com.epam.automation.collections.mainTask.candies;

public class GumGrops extends Candy {
    @Override
    public double sugarContain() {
        return getWeight()*0.6;
    }

    public GumGrops() {
    }

    public GumGrops(String name) {
        super(name);
    }

    public GumGrops(String name, String manufacturer, double weight) {
        super(name, manufacturer, weight);
    }
    @Override
    public String toString() {
        return "\nGumGrops{" +
                "name='" + getName() + '\'' +
                ", manufacturer='" + getManufacturer() + '\'' +
                ", weight=" + getWeight() +
                ", sugarContain='" + sugarContain()+
                '}';
    }
}

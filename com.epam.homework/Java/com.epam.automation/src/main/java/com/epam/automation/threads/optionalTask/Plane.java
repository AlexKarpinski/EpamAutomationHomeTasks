package com.epam.automation.threads.optionalTask;

public class Plane {
    private String name;
    boolean inAirport = false;
    boolean isFly = false;

    public Plane(String name) {
        this.name = name;
    }

    public boolean isInAirport() {
        return inAirport;
    }

    void setInAirport() {
        this.inAirport = true;
    }

    public boolean isFly() {
        return isFly;
    }

    public void setFly() {
        this.isFly = true;
    }

    public String getName() {
        return name;
    }
}

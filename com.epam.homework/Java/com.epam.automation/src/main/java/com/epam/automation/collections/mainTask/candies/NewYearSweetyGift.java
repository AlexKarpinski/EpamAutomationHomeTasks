package com.epam.automation.collections.mainTask.candies;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewYearSweetyGift {
    private List<Candy> candies = new ArrayList<>();
    private String name;
    private int numberOfCandies;

    public NewYearSweetyGift(String name) {
        this.name = name;
    }
    public int getNumberOfCandies(){
    return candies.size()+1;
    }


    public void add(Candy candy) {
        if (candy == null) {
            throw new IllegalArgumentException();
        }
        candies.add(candy);
    }

    public List<Candy> getCandies() {
        return candies;
    }

    public void setCandies(List<Candy> candies) {
        this.candies = candies;
    }

    public int getGiftWeight(){
       double weight = 0;
        for(Candy candy:candies){
            weight += candy.getWeight();
        }
        return (int)weight;
    }

    @Override
    public String toString() {
        return "NewYearSweetyGift{" +
                "candies=" + candies +
                ", numberOfCandies=" + getNumberOfCandies() +
                ", name='" + name + '\'' +
                '}';
    }

    public void candyWithSugar(){
        System.out.println("Введите диапозон значенией содержание сахара");
        Scanner scanner = new Scanner(System.in);
        System.out.println("min: ");
        double min = scanner.nextDouble();
        System.out.println("max: ");
        double max = scanner.nextDouble();
        List<Candy> listCandy = new ArrayList<>();

        for(Candy candy: candies){
            if (candy.sugarContain() > min && candy.sugarContain() < max){
                listCandy.add(candy);
            }
        }

        System.out.println(listCandy);
    }
}

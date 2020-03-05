package com.epam.automation.collections.mainTask.candies;

import java.util.Comparator;

public class ComparatorSugar implements Comparator<Candy> {
    @Override
    public int compare(Candy o1, Candy o2) {
        return Double.compare(o1.sugarContain(), o2.sugarContain());
    }

}

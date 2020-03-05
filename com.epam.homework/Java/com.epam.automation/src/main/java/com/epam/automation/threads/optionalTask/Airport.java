package com.epam.automation.threads.optionalTask;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    private static List<Runway> runways = new ArrayList<>();
    private static List<Plane> planes = new ArrayList<>();
    private String name;

    static {
        for (int i = 1; i < 6; i++) {
            runways.add(new Runway(i));
        }
        for (int i = 1; i < 11; i++) {
            planes.add(new Plane("Самолёт " + i));
        }
        for (Runway runway : runways) {
            runway.setPlanes(Airport.getPlanes());
            runway.start();
        }
    }

    private static List<Plane> getPlanes() {
        return planes;
    }

    Airport(String name) {
        this.name = name;
    }
}

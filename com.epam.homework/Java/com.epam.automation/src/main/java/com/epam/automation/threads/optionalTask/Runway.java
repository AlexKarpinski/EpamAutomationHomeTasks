package com.epam.automation.threads.optionalTask;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Runway extends Thread {
    private boolean isFree = true;
    private int id;
    private List<Plane> planes;

    public Runway(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    private void setFree() {
        isFree = false;
    }

    void setPlanes(List<Plane> planes) {
        this.planes = planes;
    }

    private synchronized void loadPlane(Plane plane) {
        if (!plane.inAirport && !plane.isFly) {
            plane.setInAirport();
            setFree();
            System.out.println(plane.getName() + " начал выход на полосу " + getId());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(plane.getName() + " взлетел с полосы " + getId());
            plane.setFly();
        }
    }

    @Override
    public void run() {
        for (Plane plane : planes) {
            loadPlane(plane);
        }
    }
}

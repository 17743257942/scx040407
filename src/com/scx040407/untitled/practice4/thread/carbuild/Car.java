package com.scx040407.untitled.practice4.thread.carbuild;

/**
 * 2018/07/29 ÏÂÎç 3:06
 */
public class Car {
    private final int id;
    private boolean engine = false,
            driveTrain = false,
            wheels = false;

    public Car() {
        id = -1;
    }

    public Car(int id) {
        this.id = id;
    }

    public synchronized int getId() {
        return id;
    }

    public synchronized void addEngine() {
        engine = true;
    }

    public synchronized void addDriveTrain() {
        driveTrain = true;
    }

    public synchronized void addWheels() {
        wheels = true;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", engine=" + engine +
                ", driveTrain=" + driveTrain +
                ", wheels=" + wheels +
                '}';
    }
}

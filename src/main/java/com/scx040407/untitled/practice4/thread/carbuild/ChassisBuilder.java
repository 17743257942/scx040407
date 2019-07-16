package com.scx040407.untitled.practice4.thread.carbuild;

import java.util.concurrent.TimeUnit;

/**
 * 2018/07/29 ÏÂÎç 3:10
 */
public class ChassisBuilder implements Runnable {
    private CarQueue carQueue;
    private int counter = 0;

    public ChassisBuilder(CarQueue carQueue) {
        this.carQueue = carQueue;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(500);
                // make chassis
                Car c = new Car(counter++);
                System.out.println("ChassisBuilder created " + c);
                // insert into queue
                carQueue.put(c);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted: ChassisBuilder");
        }
        System.out.println("ChassisBuilder off");
    }
}

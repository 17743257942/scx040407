package com.scx040407.untitled.practice4.thread.car2;

import java.util.concurrent.TimeUnit;

/**
 * 2018/07/07 ÏÂÎç 7:50
 */
public class WaxOn2 implements Runnable {
    private Car2 car2;

    public WaxOn2(Car2 car2) {
        this.car2 = car2;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("wax on! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car2.waxed();
                car2.waitForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("ending wax on task");
    }
}

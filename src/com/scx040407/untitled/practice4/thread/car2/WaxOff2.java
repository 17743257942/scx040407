package com.scx040407.untitled.practice4.thread.car2;

import java.util.concurrent.TimeUnit;

/**
 * 2018/07/07 ÏÂÎç 7:50
 */
public class WaxOff2 implements Runnable {
    private Car2 car2;

    public WaxOff2(Car2 car2) {
        this.car2 = car2;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car2.waitForWaxing();
                System.out.println("wax off");
                TimeUnit.MILLISECONDS.sleep(200);
                car2.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("exiting via interrupt");
        }
        System.out.println("ending wax off task");
    }
}

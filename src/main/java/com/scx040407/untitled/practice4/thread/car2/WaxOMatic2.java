package com.scx040407.untitled.practice4.thread.car2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 2018/07/07 обнГ 7:50
 */
public class WaxOMatic2 {
    public static void main(String[] args) throws InterruptedException {
        Car2 car2 = new Car2();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff2(car2));
        exec.execute(new WaxOn2(car2));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}

package com.scx040407.untitled.practice4.thread.restaurant;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 2018/07/28 ионГ 12:19
 */
public class RestaurantWithQueues {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        Restaurant restaurant = new Restaurant(exec, 5, 2);
        exec.execute(restaurant);
        TimeUnit.MILLISECONDS.sleep(2000);
        exec.shutdownNow();

    }
}

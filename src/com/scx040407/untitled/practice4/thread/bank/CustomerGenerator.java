package com.scx040407.untitled.practice4.thread.bank;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 2018/07/23 ÏÂÎç 10:11
 */
public class CustomerGenerator implements Runnable {
    private CustomerLine customers;
    private static Random random = new Random(47);

    public CustomerGenerator(CustomerLine cq) {
        customers = cq;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(300));
                customers.put(new Customer(random.nextInt(1000)));
            }
        } catch (InterruptedException e) {
            System.out.println("CustomerGenerator interrupted");
        }
        System.out.println("CustomerGenerator terminating");
    }
}

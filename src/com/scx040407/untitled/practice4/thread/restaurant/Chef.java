package com.scx040407.untitled.practice4.thread.restaurant;


import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 2018/07/27 ÏÂÎç 11:51
 */
public class Chef implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final Restaurant restaurant;
    private static Random random = new Random(47);

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //Blocks until an order appears
                Order order = restaurant.orders.take();
                Food requestedItem = order.item();
                //Time to prepare order
                TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
                Plate plate = new Plate(order, requestedItem);
                order.getWaitPerson().filledOrders.put(plate);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " off duty");
    }

    @Override
    public String toString() {
        return "Chef{" +
                "id=" + id +
                '}';
    }
}

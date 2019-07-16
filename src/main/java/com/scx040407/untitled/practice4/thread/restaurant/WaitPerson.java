package com.scx040407.untitled.practice4.thread.restaurant;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 2018/07/27 ÏÂÎç 11:44
 */
public class WaitPerson implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final Restaurant restaurant;
    BlockingQueue<Plate> filledOrders =
            new LinkedBlockingDeque<>();

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void placeOrder(Customer customer, Food food) {
        try {
            //shouldn't actually block because this is
            // a LinkedBlockingQueue with no size limit
            restaurant.orders.put(new Order(customer, this, food));

        } catch (Exception e) {
            System.out.println(this + " placeOrder interrupted");
        }


    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Blocks until a course is ready
                Plate plate = filledOrders.take();
                System.out.println(this + "received " + plate +
                        " delivering to " +
                        plate.getOrder().getCustomer());
                plate.getOrder().getCustomer().deliver(plate);
            }
        } catch (InterruptedException e) {
            System.out.println(this+" interrupted");
        }
        System.out.println(this +" off duty");
    }

    @Override
    public String toString() {
        return "WaitPerson{" +
                "id=" + id +
                '}';
    }
}

package com.scx040407.untitled.practice4.thread.restaurant;


import java.util.concurrent.SynchronousQueue;

/**
 * 2018/07/27 ÏÂÎç 11:03
 */
public class Customer implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private final WaitPerson waitPerson;
    // only one course at a time can be received;
    private SynchronousQueue<Plate> placeSetting =
            new SynchronousQueue<>();

    public Customer(WaitPerson w) {
        waitPerson = w;
    }

    public void deliver(Plate plate) throws InterruptedException {
        placeSetting.put(plate);
    }


    @Override
    public void run() {
        for (Course course : Course.values()) {
            Food food = course.randomSelection();
            try {
                waitPerson.placeOrder(this, food);
                // block until course has been delivered
                System.out.println(this + "eating " +
                        placeSetting.take());

            } catch (InterruptedException e) {
                System.out.println(this + "waiting for " +
                        course + " interrupted");
                break;
            }
        }
        System.out.println(this + "finished meal, leaving");
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                '}';
    }
}

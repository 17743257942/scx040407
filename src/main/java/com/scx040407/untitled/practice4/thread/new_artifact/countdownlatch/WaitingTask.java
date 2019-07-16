package com.scx040407.untitled.practice4.thread.new_artifact.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 2018/07/21 ÏÂÎç 11:24
 */
public class WaitingTask implements Runnable{
    private static int counter=0;
    private final int id = counter++;
    private final CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String toString() {
        return "WaitingTask{" +
                "id=" + id +
                '}';
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("Latch barrier passed for "+this);
        } catch (InterruptedException e) {

        }
    }

}

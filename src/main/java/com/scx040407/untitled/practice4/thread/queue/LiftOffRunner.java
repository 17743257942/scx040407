package com.scx040407.untitled.practice4.thread.queue;

import java.util.concurrent.BlockingQueue;

/**
 * 2018/07/10 ÏÂÎç 11:18
 */
public class LiftOffRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
        this.rockets = rockets;
    }

    public void add(LiftOff liftOff) {
        try {
            rockets.put(liftOff);

        } catch (InterruptedException e) {
            System.out.println("Interrupted during put()");
        }
    }
    @Override
    public void run() {
        try{
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        } catch (InterruptedException e) {
            System.out.println("waking from take()");
        }
        System.out.println("Exiting LiftOffRunner");
    }
}

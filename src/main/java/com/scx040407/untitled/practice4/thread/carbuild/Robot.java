package com.scx040407.untitled.practice4.thread.carbuild;

import java.util.concurrent.BrokenBarrierException;

/**
 * 2018/07/29 ÏÂÎç 3:21
 */
abstract class Robot implements Runnable {
    private RobotPool pool;

    public Robot(RobotPool p) {
        pool = p;
    }

    protected Assembler assembler;

    public Robot assignAssembler(Assembler assembler) {
        this.assembler = assembler;
        return this;
    }

    private boolean engage = false;

    public synchronized void engage() {
        engage = true;
        notifyAll();
    }

    //the part of run() that's different for each robot
    abstract protected void performService();

    @Override
    public void run() {
        try {
            powerDown(); //wait until needed
            while (!Thread.interrupted()) {
                performService();
                assembler.barrier().await(); //synchronize
                //we're done with that job...
                powerDown();
            }

        } catch (InterruptedException e) {
            System.out.println("Exiting " + this + "via interrupt");
        } catch (BrokenBarrierException e) {
            //this one we want to know about
            throw new RuntimeException(e);
        }
        System.out.println(this + "off");
    }

    private synchronized void powerDown() throws InterruptedException {
        engage = false;
        assembler = null; //disconnect from the Assembler
        //put ourselves back in the available pool
        pool.release(this);
        while (engage == false) {
            wait();
        }
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}

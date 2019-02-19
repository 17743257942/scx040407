package com.scx040407.untitled.practice4.thread.carbuild;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 2018/07/29 ÏÂÎç 3:13
 */
public class Assembler implements Runnable {
    private CarQueue chassisQueue, finishingQueue;
    private Car car;
    private CyclicBarrier barrier = new CyclicBarrier(4);
    private RobotPool robotPool;

    public Assembler(CarQueue cq, CarQueue fq, RobotPool rp) {
        chassisQueue = cq;
        finishingQueue = fq;
        robotPool = rp;
    }

    public Car car() {
        return car;
    }

    public CyclicBarrier barrier() {
        return barrier;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //blocks until chassis is available
                car=chassisQueue.take();
                //hire robots to perform work
                robotPool.hire(EngineRobot.class, this);
                robotPool.hire(DriveTrainRobot.class, this);
                robotPool.hire(WheelRobot.class, this);
                barrier.await(); //until the robots finish
                //put car into finishingqueue for further work
                finishingQueue.put(car);

            }
        } catch (InterruptedException e) {
            System.out.println("exiting assembler via interrupt");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Assembler off");
    }
}

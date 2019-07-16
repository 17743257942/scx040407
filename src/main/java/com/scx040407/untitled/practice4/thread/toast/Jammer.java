package com.scx040407.untitled.practice4.thread.toast;

/**
 * 2018/07/17 ÏÂÎç 10:28
 */
public class Jammer implements Runnable {

    private ToastQueue butterdQueue, finishedQueue;

    public Jammer(ToastQueue butterdQueue, ToastQueue finishedQueue) {
        this.butterdQueue = butterdQueue;
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = butterdQueue.take();
                t.jam();
                System.out.println(t);
                finishedQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("Jammer off");
        }
    }
}

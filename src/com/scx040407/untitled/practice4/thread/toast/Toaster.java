package com.scx040407.untitled.practice4.thread.toast;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 2018/07/17 ÏÂÎç 9:59
 */
public class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random(47);

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(
                        100 + rand.nextInt(500)
                );
                Toast t = new Toast(count++);
                System.out.println(t);
                toastQueue.put(t);

            }
        } catch (InterruptedException e) {
            System.out.println("Toaster off");

        }
    }
}

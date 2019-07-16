package com.scx040407.untitled.practice4.thread.new_artifact.delayqueue;

import java.util.concurrent.DelayQueue;

/**
 * 2018/07/22 обнГ 5:18
 */
public class DelayedTaskConsumer implements Runnable {
    private DelayQueue<DelayedTask> q;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                q.take().run();
            }
        } catch (InterruptedException e) {

        }
        System.out.println("Finished DelayedTaskConsumer");
    }
}

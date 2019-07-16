package com.scx040407.untitled.practice4.thread.chopstic;

/**
 * 2018/07/19 обнГ 9:36
 */
public class Chopstick {
    private boolean taken = false;
    public synchronized void take() throws InterruptedException {
        while (taken) {
            wait();
        }
        taken = true;
    }
    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}

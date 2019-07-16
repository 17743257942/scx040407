package com.scx040407.untitled.practice4.thread.blocker;

public class Task implements Runnable {
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}

package com.scx040407.untitled.practice4.thread.queue;

/**
 * 2018/07/10 обнГ 11:19
 */
public class LiftOff {
    private int i;

    public LiftOff(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "LiftOff{" +
                "i=" + i +
                '}';
    }

    public void run() {
        System.out.println("liftoff run..." + i);
    }
}

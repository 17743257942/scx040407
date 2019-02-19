package com.scx040407.untitled.practice4.thread.chopstic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 2018/07/19 ÏÂÎç 11:29
 */
public class FixedDiningPhilosophers {
    public static void main(String[] args) throws Exception {
        int ponder = 0;
        if (args.length > 0) {
            ponder = Integer.parseInt(args[0]);
        }
        int size = 5;
        if (args.length > 1) {
            size = Integer.parseInt(args[1]);
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            sticks[i] = new Chopstick();
        }
        for (int i = 0; i < size; i++) {
            if (i < (size - 1)) {
                exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder));
            } else {
                exec.execute(new Philosopher(sticks[0], sticks[(i) % size], i, ponder));
            }
        }
        if (args.length == 3 && args[2].equals("timeout")) {
            TimeUnit.SECONDS.sleep(5);
        } else {
            System.out.println("Press Enter to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}

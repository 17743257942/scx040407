package com.scx040407.untitled.practice4.thread.carbuild;

import java.util.HashSet;
import java.util.Set;

/**
 * 2018/07/29 ÏÂÎç 3:52
 */
public class RobotPool {
    //quietly privents identical entries
    private Set<Robot> pool = new HashSet<>();

    public synchronized void add(Robot robot) {
        pool.add(robot);
        notifyAll();
    }

    public synchronized void hire(Class<? extends Robot> robotType,
                                  Assembler d) throws InterruptedException {
        for (Robot r : pool) {
            if (r.getClass().equals(robotType)) {
                pool.remove(r);
                r.assignAssembler(d);
                r.engage(); // power it up to do the task
                return;
            }
        }
        wait();
        hire(robotType, d); // try again recursively
    }

    public synchronized void release(Robot robot) {
        add(robot);
    }
}

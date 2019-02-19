package com.scx040407.untitled.practice4.thread.carbuild;

/**
 * 2018/07/29 обнГ 4:07
 */
public class WheelRobot extends Robot {
    public WheelRobot(RobotPool pool) {
        super(pool);
    }
    @Override
    protected void performService() {
        System.out.println(this + " installing wheels");
        assembler.car().addWheels();
    }
}

package com.scx040407.untitled.practice4.thread.carbuild;

/**
 * 2018/07/29 обнГ 4:06
 */
public class DriveTrainRobot extends Robot {
    public DriveTrainRobot(RobotPool pool) {
        super(pool);
    }
    @Override
    protected void performService() {
        System.out.println(this + " installing DriveTrain");
        assembler.car().addDriveTrain();
    }
}

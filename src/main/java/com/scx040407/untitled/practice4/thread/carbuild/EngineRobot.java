package com.scx040407.untitled.practice4.thread.carbuild;

/**
 * 2018/07/29 обнГ 4:05
 */
public class EngineRobot extends Robot {

    public EngineRobot(RobotPool pool) {
        super(pool);
    }
    @Override
    protected void performService() {
        System.out.println(this + " installing engine");
        assembler.car().addEngine();

    }
}

package com.scx040407.untitled.practice2.gen.performing;

import com.scx040407.untitled.practice2.gen.performs.Robot;

public class LatentReflection {
    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Robot());
        CommunicateReflectively.perform(new Mime());
    }
}

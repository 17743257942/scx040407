package com.scx040407.untitled.practice2.gen.performs;

public class Communicate {
    public static <T extends Performs> void perform(T performer) {
        performer.speak();
        performer.sit();
    }
}

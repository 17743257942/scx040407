package com.scx040407.untitled.practice.InnerClassTest;

public class Wrapping {
    private int i;
    public Wrapping(int x) {
        i = x;
    }
    public int value() {
        return i;
    }

    @Override
    public String toString() {
        return "Wrapping{" +
                "i=" + i +
                '}';
    }
}

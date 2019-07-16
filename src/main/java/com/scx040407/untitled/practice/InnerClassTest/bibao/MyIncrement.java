package com.scx040407.untitled.practice.InnerClassTest.bibao;

public class MyIncrement {
    public void increment() {
        System.out.println("Other operation");
    }

    static void f(MyIncrement myIncrement) {
        myIncrement.increment();
    }
}

package com.scx040407.untitled.practice.InnerClassTest.AB;

public class MultiInterfaces {
    static void taskA(A a) {

    }

    static void taskB(B b) {

    }

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        taskA(x);
        taskA(y);
        taskB(x);
        taskB(y.makeB());
    }
}

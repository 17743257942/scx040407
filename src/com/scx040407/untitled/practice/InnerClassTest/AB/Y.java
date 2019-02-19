package com.scx040407.untitled.practice.InnerClassTest.AB;

public class Y implements A {
    B makeB() {
        return new B() {};
    }
}

package com.scx040407.untitled.practice.InnerClassTest.interfaces;

public class Y {
    public static void main(String[] args) {
        // X实现了两个接口，所以两个接口都可以接收X类
        A a = new X();
        B b = new X();
        // Z继承了Y实现了A,B所以ABY都能接收Z
        A z0 = new Z();
        B z1 = new Z();
        Y z2 = new Z();
    }
}

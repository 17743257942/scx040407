package com.scx040407.untitled.practice.InnerClassTest.interfaces;

public class Y {
    public static void main(String[] args) {
        // Xʵ���������ӿڣ����������ӿڶ����Խ���X��
        A a = new X();
        B b = new X();
        // Z�̳���Yʵ����A,B����ABY���ܽ���Z
        A z0 = new Z();
        B z1 = new Z();
        Y z2 = new Z();
    }
}

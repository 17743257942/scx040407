package com.scx040407.untitled.practice.exception;

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            new ExceptionTest().test();
        } catch (MyException e) {
            e.printStackTrace();
        }
        System.out.println("2018��1��23��06:28:57");
    }
    protected  void test() throws MyException {
        int x = 3;
        if (x > 0) {
            throw new MyException("�Զ����쳣");
        }
    }
}

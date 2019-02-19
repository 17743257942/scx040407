package com.scx040407.untitled.practice.exception;

public class ExceptionTest2 extends ExceptionTest {

    public static void main(String[] args) {

    }

    @Override
    protected void test() throws MyException { //子类方法能抛的异常小于等于父类
        super.test();
    }
}

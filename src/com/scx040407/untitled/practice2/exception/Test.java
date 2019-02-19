package com.scx040407.untitled.practice2.exception;

public class Test {
    public static void main(String[] args) {
        try {
            f();
        } catch (SimpleException e) {
            e.printStackTrace(System.out);
        }
    }
    public static void f() throws SimpleException{
        System.out.println("ffffff");
        throw new SimpleException("111111111111");
    }
    public static void g() throws SimpleException{
        System.out.println("gggg");
        throw new SimpleException();
    }
}

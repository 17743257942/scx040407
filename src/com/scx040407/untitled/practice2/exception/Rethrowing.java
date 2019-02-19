package com.scx040407.untitled.practice2.exception;

public class Rethrowing {
    static void f() throws Exception {
        System.out.println("originating the Exception in f()");
        throw new Exception("thrown from f()");
    }

    static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("inside g(),e.printStackTrace()");
            e.printStackTrace(System.out);
            throw e;
        }
    }

    static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("inside h(),e.printStackTrace()");
            e.printStackTrace(System.out);
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
        try {
            h();
        } catch (Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}

package com.scx040407.untitled.practice2.exception;

public class WhoCalled {
    static int i = 0;
    static void f() {
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace()
                    ) {
                System.out.println(ste + "   " + i++);
            }
        }
    }

    static void g() {
        f();
    }

    static void h() {
        g();
    }

    public static void main(String[] args) {
        h();
    }


}

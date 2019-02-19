package com.scx040407.untitled.practice2.gen.method;

public class GenericMethods {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods g = new GenericMethods();
        g.f(" ");
        g.f(2);
        g.f(2.1);
        g.f(1.0F);
        g.f(222L);
        g.f(g);
    }
}

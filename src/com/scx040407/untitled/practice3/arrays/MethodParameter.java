package com.scx040407.untitled.practice3.arrays;

public class MethodParameter<T> {
    public static <G> G[] f(G[] arg) {
        return arg;
    }

    public T[] g(T[] arg) {
        return arg;
    }
}

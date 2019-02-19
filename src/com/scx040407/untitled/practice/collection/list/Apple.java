package com.scx040407.untitled.practice.collection.list;

public class Apple {
    private static long counter;
    private final long id = counter++;
    public long id() {
        return id;
    }
}

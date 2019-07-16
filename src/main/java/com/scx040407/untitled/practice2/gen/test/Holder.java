package com.scx040407.untitled.practice2.gen.test;

public class Holder<T> {
    private T value;
    public Holder() {}

    public Holder(T value) {
        this.value = value;
    }
    public T get() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }
}

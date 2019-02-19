package com.scx040407.untitled.practice2.gen.factory;

public class Foo2<T> {
    private T x;

    public <F extends FactoryI<T>> Foo2(F factory) {
        x = factory.create();
    }














}

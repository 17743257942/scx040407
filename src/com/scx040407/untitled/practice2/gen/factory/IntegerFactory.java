package com.scx040407.untitled.practice2.gen.factory;

public class IntegerFactory implements FactoryI<Integer> {
    @Override
    public Integer create() {
        return new Integer(0);
    }
}

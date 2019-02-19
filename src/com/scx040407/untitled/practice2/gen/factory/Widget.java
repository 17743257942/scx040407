package com.scx040407.untitled.practice2.gen.factory;

public class Widget {
    public static class Factory implements FactoryI<Widget> {
        @Override
        public Widget create() {
            return new Widget();
        }
    }
}

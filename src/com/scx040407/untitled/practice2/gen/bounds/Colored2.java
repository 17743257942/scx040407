package com.scx040407.untitled.practice2.gen.bounds;

public class Colored2<T extends HasColor> extends HoldItem<T> {
    Colored2(T item) {
        super(item);
    }
    java.awt.Color color() {
        return item.getColor();
    }
}

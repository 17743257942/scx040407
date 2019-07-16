package com.scx040407.untitled.practice2.gen.bounds;

public class HoldItem<T> {
    T item;

    HoldItem(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }
}

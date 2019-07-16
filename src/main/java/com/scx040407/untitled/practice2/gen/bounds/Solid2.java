package com.scx040407.untitled.practice2.gen.bounds;

import java.awt.*;

public class Solid2 <T extends Dimension & HasColor & Weight> extends ColoredDimension2<T> {
    Solid2(T item) {
        super(item);
    }
    int weight() {
        return item.weight();
    }


}

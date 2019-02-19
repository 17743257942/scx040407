package com.scx040407.untitled.practice.collection.list;

import java.util.ArrayList;

public class ApplesAndOrangesWithoutGenerics {
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        apples.add(new Orange());
        for (int i = 0; i < apples.size() - 1; i++) {
            System.out.println(((Apple)apples.get(i)).id());
        }
    }
}

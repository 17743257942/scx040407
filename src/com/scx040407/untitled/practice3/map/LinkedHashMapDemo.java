package com.scx040407.untitled.practice3.map;

import com.scx040407.untitled.MapGen;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedMap =
                new LinkedHashMap<>(MapGen.getMap(0,9));
        System.out.println(linkedMap);
        linkedMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedMap.putAll(MapGen.getMap(0, 9));
        System.out.println(linkedMap);
        for (int i = 0; i < 6; i++) {
            linkedMap.get(i);
        }
        System.out.println(linkedMap);
        linkedMap.get(0);
        System.out.println(linkedMap);
    }
}

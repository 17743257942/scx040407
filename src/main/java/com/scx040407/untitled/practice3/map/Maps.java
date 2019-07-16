package com.scx040407.untitled.practice3.map;

import java.util.HashMap;
import java.util.Map;

public class Maps {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "aaa");
        map.put(2, "baa");
        map.put(13, "caa");
        map.put(4, "daa");
        map.put(15, "eaa");
        map.put(6, "faa");
        map.put(17, "gaa");
        System.out.println(map.keySet());
        System.out.println(map.values());
        String s =map.getClass().getSimpleName();
        System.out.println(s);
        if ("HashMap".equals(s)) {
            System.out.println("is hashmap");
        }
    }
}

package com.scx040407.untitled;

import java.util.HashMap;
import java.util.Map;

public class MapGen {
    public static Map<Integer, String> getMap(int keyFrom, int count) {
        Map<Integer,String> map = new HashMap<>();
        for (int i = keyFrom; i < keyFrom + count; i++) {
            map.put(i, ListGen.getString(6));
        }
        return map;
    }

    public static Map<String, String> getMap2(int keyFrom, int count) {
        Map<String,String> map = new HashMap<>();
        for (int i = keyFrom; i < keyFrom + count; i++) {
            map.put(String.valueOf(i), ListGen.getString(6));
        }
        return map;
    }

    public static void main(String[] args) {
        Map m = getMap(0, 4);
        System.out.println(m);
    }
}

package com.scx040407.untitled.practice.collection.iterator;

import java.util.Arrays;

public class AdapterMethodIdiom {
    public static void main(String[] args) {
        ReversableArrayList<String> r = new ReversableArrayList<>(Arrays.asList("aa","bb","cc","dd"));
        for (String s : r) {
            System.out.print("  ReversableArrayList::" + s);
        }
        System.out.println();
        for (String s : r.reversed()) {
            System.out.print("  reversed::" + s);
        }
    }
}

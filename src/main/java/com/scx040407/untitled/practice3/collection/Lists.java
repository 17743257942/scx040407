package com.scx040407.untitled.practice3.collection;

import com.scx040407.untitled.ListGen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterator<String> it;
    private static ListIterator<String> lit;

    public static void basicTest(List<String> a) {
        a.add(1, "x");
        a.add("x");
        lit = a.listIterator();
        a.addAll(ListGen.getList2(1));
        a.addAll(3, ListGen.getList2(1));
        b = a.contains(ListGen.getList2(1).get(0));
        System.out.println("b: " + b);
        b = a.containsAll(ListGen.getList2(1));
        System.out.println("b: " + b);
        a.retainAll(ListGen.getList2(1));
        a.removeAll(ListGen.getList2(1));
        for (String str : a
                ) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        basicTest(new ArrayList<String>(ListGen.getList(20)));
    }
}

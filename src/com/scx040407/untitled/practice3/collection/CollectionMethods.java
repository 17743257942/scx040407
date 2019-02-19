package com.scx040407.untitled.practice3.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionMethods {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();
        c.add("111");
        c.add("222");
        Collection<String> c1 = new ArrayList<String>();
        c1.addAll(c);
        c1.add("333");
        System.out.println(c1);
        Object[] array = c1.toArray();
        String[] strs =  c1.toArray(new String[0]);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("-------");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println("-----------");
    }
}

package com.scx040407.untitled.practice3.collection;

import java.util.*;

public class Unsupported {
    static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);
        // copy of the sublist
        Collection<String> c2 = new ArrayList<>(subList);
        try {
            boolean a = c.retainAll(c2);
            System.out.println(a);
        } catch (Exception e) {
            System.out.println("retainAll(): " + e);
        }
        try {
            boolean a = c.remove(c2);
            System.out.println(a);
        } catch (Exception e) {
            System.out.println("removeAll(): " + e);
        }
        try {
            c.clear();
        } catch (Exception e) {
            System.out.println("clear(): " + e);
        }
        try {
            boolean a = c.add("X");
            System.out.println(a);
        } catch (Exception e) {
            System.out.println("add(): " + e);
        }
        try {
            boolean a = c.addAll(c2);
            System.out.println(a);
        } catch (Exception e) {
            System.out.println("addAll(): " + e);
        }
        try {
            boolean a = c.remove("C");
            System.out.println(a);
        } catch (Exception e) {
            System.out.println("remove(): " + e);
        }
        // the list.set() method modifies the value but
        // doesn't change the size of the data structure
        try {
            String a = list.set(0, "X");
            System.out.println(a);
        } catch (Exception e) {
            System.out.println("list.set(): " + e);
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L"
                .split(" "));
        test("Modifiable copy", new ArrayList<String>(list));
        test("Arrays.asList()", list);
        test("unmodifiableList()", Collections
                .unmodifiableList(new ArrayList<String>(list)));

    }
}

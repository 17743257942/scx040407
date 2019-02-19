package com.scx040407.untitled.practice;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("bbbb");
//        list.add(null); //list??????null
        list.add("cccc");
        list.add("dddd");

//        iteratorTest(list);
//        addAllTest(list);
//        linkedListTest();

    }

    private static void linkedListTest() {
        List<String> list3 = new LinkedList<>();
        list3.add("a3");
        list3.add("b3");
        list3.add("c3");
        list3.remove("b3");
        list3.remove(1);
        System.out.println(list3.get(0)); //a3
    }

    private static void addAllTest(List<String> list) {
        List<String> list1 = new ArrayList<>();
        list1.addAll(list);

        List<String> list2 = new ArrayList<>();
        list2.addAll(list);
        list2.addAll(list1);
        for (String s :
                list2) {
            System.out.println(s);
        }
    }

    private static void iteratorTest(List<String> list) {
        Iterator iterator = list.iterator();
        //?????????iterator????????????
        while (iterator.hasNext()) {
            if (iterator.next().equals("bbbb")) {
                System.out.println("shan chu ---------------");
                iterator.remove();
            }
        }
    }
}

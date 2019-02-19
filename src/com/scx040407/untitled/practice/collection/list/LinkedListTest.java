package com.scx040407.untitled.practice.collection.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        List<String> a = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff");
        list.addAll(a);
        System.out.println(list);
//        list.removeAll(a);
        System.out.println("getFirst::"+list.getFirst());
        list.removeFirst();
//        list.removeAll(a);
        System.out.println("removeFirst + peek::"+list.peek());
        list.offer("ggg");

        System.out.println("offer::"+list);
        list.add("hhh");
        System.out.println(list);
        System.out.println("poll::"+list.poll());
        System.out.println(list);

    }
}

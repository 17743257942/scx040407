package com.scx040407.untitled.practice.collection.set;

import java.util.*;

public class SetTest {
    private static int count = 0;
    static Set<Character> metaChar = new HashSet<>();
    static {
        metaChar.add('a');
        metaChar.add('e');
        metaChar.add('i');
        metaChar.add('o');
        metaChar.add('u');
    }

    public static void countMeta(String word) {
        char[] chars = word.toCharArray();
        LinkedList<Character> set = new LinkedList<>();
        for (Character c : chars) {
            set.add(c);
        }
        Iterator<Character> iterator = set.iterator();
        while (iterator.hasNext()) {
            Character c = iterator.next();
            if (metaChar.contains(c)) {
                count++;
            }
        }
        System.out.println(set);
        System.out.println(count);
    }

    public static void main(String[] args) {

        countMeta("abcdabcd");
    }
}

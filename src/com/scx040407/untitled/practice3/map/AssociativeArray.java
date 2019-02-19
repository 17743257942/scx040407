package com.scx040407.untitled.practice3.map;

import java.util.Arrays;

public class AssociativeArray<K, V> {
    private Object[][] pairs;
    private int index;

    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        if (index >= pairs.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        pairs[index++] = new Object[]{key, value};
    }

    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key.equals(pairs[i][0])) {
                return (V) pairs[i][1];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString())
                    .append(" : ")
                    .append(pairs[i][1].toString());
            if (i < index - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
//        String[][] strings = new String[2][3];//ÐÐ£¬ÁÐ
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 3; j++) {
//                strings[i][j] = "aa"+j;
//                System.out.print(i+":"+j+"  ");
//            }
//            System.out.println();
//        }
//        System.out.println(strings.length);

        AssociativeArray<String, String> map =
                new AssociativeArray<>(6);
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tail");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("too many objects!");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));
    }
}

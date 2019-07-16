package com.scx040407.untitled.practice.collection.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collection2Test {
    private Integer[] ints = {1, 2, 3, 3, 4, 5, 6, 11};

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;

            public boolean hasNext() {
                return index < ints.length;
            }

            public Integer next() {
                return ints[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        Collection2Test c2 = new Collection2Test();
        Iterator i = c2.iterator();
        while (i.hasNext()) {
            System.out.print("  c2::" + i.next());
        }

        System.out.println();
        List<Integer> lst = new ArrayList<>();
        for (int j = 1; j < 10; j++) {
            lst.add(j);
        }
        removeEvensVer3(lst);
        System.out.println(lst);

    }


    public static void removeEvensVer3(List<Integer> lst) {
        Iterator<Integer> itr = lst.iterator();
        while (itr.hasNext()) {
            if (itr.next() % 2 == 0) {
                itr.remove();
            }
        }
    }

}

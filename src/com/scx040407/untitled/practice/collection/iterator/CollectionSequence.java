package com.scx040407.untitled.practice.collection.iterator;

import java.util.AbstractCollection;
import java.util.Iterator;

public class CollectionSequence extends AbstractCollection<Iterator> {
    private Integer[] ints = {1, 2, 3, 3, 4, 5, 6, 11};

    @Override
    public Iterator iterator() {
        return new Iterator<Integer>() {
                private int index = 0;
            @Override
            public boolean hasNext() {
                return index < ints.length;
            }

            @Override
            public Integer next() {
                return ints[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public int size() {
        return ints.length;
    }

    public static void main(String[] args) {
        CollectionSequence c = new CollectionSequence();
        Iterator i = c.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}

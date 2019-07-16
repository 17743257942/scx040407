package com.scx040407.untitled.practice.collection.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ReversableArrayList<T> extends ArrayList<T> {
    public ReversableArrayList(Collection<T> c) {
        super(c);
    }

    public Iterable<T> reversed() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1;
                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public T next() {
                        return get(current--);
                    }
                };
            }
        };
    }


}

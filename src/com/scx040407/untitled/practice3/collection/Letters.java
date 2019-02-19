package com.scx040407.untitled.practice3.collection;

import com.scx040407.untitled.Generator;

import java.util.Iterator;

public class Letters implements Generator<Pair<Integer, String>>,Iterable<Integer> {
    private int size = 9;
    private int number = 1;
    private char letter = 'A';
    @Override
    public Pair<Integer, String> next() {
        return new Pair<Integer, String>(number++, "" + letter++);
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number < size;
            }

            @Override
            public Integer next() {
                return number++;
            }
        };
    }


}

package com.scx040407.untitled.practice.collection.list;

import java.util.LinkedList;

/**
 * ��linkedlistģ��ջ
 * @param <T>
 */
public class StackTest<T> {

    private LinkedList<T> storage = new LinkedList<T>();

    /**
     * ���Ԫ��
     * @param v
     */
    public void push(T v) {
        storage.addFirst(v);
    }

    /**
     *
     * @return
     */
    public T peek() {
        return storage.getFirst();
    }

    /**
     *
     * @return
     */
    public T pop() {
        return storage.removeFirst();
    }

    /**
     *
     * @return
     */
    public boolean mpty() {
        return storage.isEmpty();
    }

    /**
     *
     * @return
     */
    public String toString() {
        return storage.toString();
    }

}

package com.scx040407.untitled.practice5.test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2018/09/02 ÏÂÎç 2:14
 */
public class MyLinkedListTest<E> implements Iterable<E> {

    private int theSize;
    private int modCount = 0;
    private Node<E> beginMarker;
    private Node<E> endMarker;

    public E get(int idx) {
        return getNode(idx).data;
    }

    public Node<E> getNode(int idx) {
        Node<E> p;
        if (idx < 0 || idx > theSize) {
            throw new IndexOutOfBoundsException();
        }
        if (idx < size() / 2) {
            p = beginMarker;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > idx; i--) {
                p = p.prev;
            }
        }
        return p;
    }

    public E set(int idx, E newVal) {
        Node<E> p = getNode(idx);
        E oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public boolean add(E x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, E x) {
        addBefore(getNode(idx), x);
    }

    private void addBefore(Node<E> p, E x) {
        Node<E> newNode = new Node<E>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    public E remove(Node<E> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;
        return p.data;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListTestIterator();
    }

    private class LinkedListTestIterator implements Iterator<E>{

        private Node<E> current = beginMarker.next;
        private int expectedModeCount=modCount;
        private boolean okToRemove = false;
        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public E next() {
            if (modCount != expectedModeCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E nextItem = current.data;
            current = current.next;
            okToRemove=true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModeCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            MyLinkedListTest.this.remove(current.prev);
            okToRemove = false;
            expectedModeCount++;
        }
    }


    private static class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public MyLinkedListTest() {
        clear();
    }

    public void clear() {
        beginMarker = new Node<E>(null, null, null);
        endMarker = new Node<E>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSize = 0;
        modCount++;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    public int size() {
        return theSize;
    }

}

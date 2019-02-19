package com.scx040407.untitled.practice5.sourcecode;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 2018/08/22 ÏÂÎç 11:44
 */
public class MyLinkedList<E> implements Iterable<E> {

    private int theSize;
    private int modCount = 0;
    private Node<E> beginMarker;
    private Node<E> endMarker;

    private static class Node<E> {

        public E data;
        public Node<E> prev;
        public Node<E> next;

        public Node(E d, Node<E> p, Node<E> n) {
            data = d;
            prev = p;
            next = n;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public MyLinkedList() {
        clear();
    }

    /**
     * change the size of this collection to zero
     */
    public void clear() {
        beginMarker = new Node<E>(null, null, null);
        endMarker = new Node<E>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSize = 0;
        modCount++;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return theSize == 0;
    }

    public boolean add(E x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, E x) {
        addBefore(getNode(idx), x);
    }

    public E get(int idx) {
        return getNode(idx).data;
    }

    public E set(int idx, E newVal) {
        Node<E> p = getNode(idx);
        E oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public E remove(int idx) {
        return remove(getNode(idx));
    }

    private void addBefore(Node<E> p, E x) {
        Node<E> newNode = new Node<E>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }

    private E remove(Node<E> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;
        return p.data;
    }

    private Node<E> getNode(int idx) {
        Node<E> p;
        if (idx < 0 || idx > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (idx < size() / 2) {
            p = beginMarker.next;
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


    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "theSize=" + theSize +
                ", modCount=" + modCount +
                ", beginMarker=" + beginMarker +
                ", endMarker=" + endMarker +
                '}';
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = beginMarker.next;
        private int exceptedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public E next() {
            if (modCount != exceptedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != exceptedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
            exceptedModCount++;
        }

    }

    public static void main(String[] args) {

        MyLinkedList<String> linkedList= new MyLinkedList<>();
        linkedList.add("asdf");
        linkedList.add("asdf");
        linkedList.add("asdf");
        linkedList.add("asdf");
        linkedList.add("asdf");
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            String s = (String) iterator.next();
            System.out.println(s);
            iterator.remove();
        }
        System.out.println(linkedList);
    }

}

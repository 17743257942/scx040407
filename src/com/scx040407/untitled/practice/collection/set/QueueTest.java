package com.scx040407.untitled.practice.collection.set;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 8 1 1 1 5 14 3 1 0 1
 * B r o n t o s a u r u s
 */
public class QueueTest {
    public static void printQ(Queue queue) {
        while (queue.peek() != null) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            queue.offer(random.nextInt(i + 10));
        }
        printQ(queue);
        Queue<Character> qc = new LinkedList<Character>();
        for (char c : "Brontosaurus".toCharArray()) {
            qc.offer(c);
        }
//        System.out.println(qc);
        printQ(qc);

    }

}

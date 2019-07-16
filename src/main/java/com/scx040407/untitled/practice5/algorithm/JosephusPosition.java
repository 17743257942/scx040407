package com.scx040407.untitled.practice5.algorithm;

/**
 * 2018/08/07 下午 11:42
 * 约瑟夫环：N个人想选出一个领头人，他们排成一个环，沿着环每数到第M个人就从环中排除该人，
 * 并从下一个人开始从新数。请找出最后留在环中的人。
 */
public class JosephusPosition {
    static ListNode getJosephusPosition(int N, int M) {
        ListNode p = new ListNode();
        ListNode q = new ListNode();
        p.setData(1);
        p.setNext(new ListNode(2));
        q = p;
        p = p.getNext();
        for (int i = 2; i < N; i++) {
            p.setData(i);
            p.setNext(new ListNode(i + 1));
            p = p.getNext();
        }
        p.setNext(q);

        for (int count = 0; count < N; count++) {
            for (int i = 0; i < M - 1; i++) {
                p = p.getNext();
            }
            p.setNext(p.getNext().getNext());
        }
        System.out.println("last player left standing (josephus position) is "
                + p.getData());
        return p;

    }

    public static void main(String[] args) {
        getJosephusPosition(10, 3);
    }
}

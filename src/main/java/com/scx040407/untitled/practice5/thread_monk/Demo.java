package com.scx040407.untitled.practice5.thread_monk;

/**
 * 2019年7月17日00:55:52
 * 和尚吃馒头问题：
 *
 */
public class Demo {

    public static void main(String[] args) {
        Box box = new Box();
        for (int i = 0; i < 30; i++) {
            new Monk("Monk" + i, box).start();
        }
    }
}

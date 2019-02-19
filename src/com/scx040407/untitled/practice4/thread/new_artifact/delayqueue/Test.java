package com.scx040407.untitled.practice4.thread.new_artifact.delayqueue;

import java.util.Random;

/**
 * 2018/07/22 обнГ 5:52
 */
public class Test {
    public static void main(String[] args) {

        Random random = new Random(47);
        for (int i = 0; i < 20; i++) {
            System.out.println(random.nextInt(5000));

        }



    }
}

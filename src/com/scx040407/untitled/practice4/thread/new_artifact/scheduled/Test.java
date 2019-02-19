package com.scx040407.untitled.practice4.thread.new_artifact.scheduled;

import java.util.Calendar;

/**
 * 2018/07/23 обнГ 9:37
 */
public class Test {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, 30);
        System.out.println(calendar.get(Calendar.MINUTE));
    }
}

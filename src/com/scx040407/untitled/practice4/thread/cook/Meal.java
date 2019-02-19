package com.scx040407.untitled.practice4.thread.cook;

/**
 * 2018/07/07 обнГ 12:57
 */
public class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "orderNum=" + orderNum +
                '}';
    }
}

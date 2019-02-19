package com.scx040407.untitled.practice4.thread.bank;

/**
 * 2018/07/23 обнГ 9:46
 */
public class Customer {


    private final int serviceTime;

    public Customer(int tm) {
        serviceTime = tm;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    @Override
    public String toString() {
        return "[" +
                 serviceTime +
                ']';
    }
}

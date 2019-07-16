package com.scx040407.untitled.practice4.thread.bank;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 2018/07/23 обнГ 10:09
 */
public class CustomerLine extends ArrayBlockingQueue<Customer> {
    public CustomerLine(int capacity) {
        super(capacity);
    }
    public String toString() {
        if (this.size() == 0) {
            return "[empty]";
        }
        StringBuilder builder = new StringBuilder();
        for (Customer customer : this) {
            builder.append(customer);
        }
        return builder.toString();
    }
}

package com.scx040407.untitled.practice2.gen.innerclass;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BankTeller {
    public static void serve(Teller t, Customer c) {
        System.out.println(t + " serve " + c);
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        for (int i = 0; i < 15; i++){
            line.add(Customer.generator().next());
        }
        for (Customer c : line) {
            serve(Teller.generator().next(), c);
        }
    }
}

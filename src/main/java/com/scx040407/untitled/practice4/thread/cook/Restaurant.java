package com.scx040407.untitled.practice4.thread.cook;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 2018/07/07 обнГ 12:59
 */
public class Restaurant {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}

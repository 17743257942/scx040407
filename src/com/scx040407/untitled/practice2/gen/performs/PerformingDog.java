package com.scx040407.untitled.practice2.gen.performs;

public class PerformingDog extends Dog implements Performs{
    @Override
    public void speak() {
        System.out.println("dogwoo");
    }

    @Override
    public void sit() {
        System.out.println("dogsitting");
    }
}

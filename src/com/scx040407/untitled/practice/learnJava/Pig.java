package com.scx040407.untitled.practice.learnJava;

public class Pig {
    int id ;
    void eat(){
        System.out.println("pig eat");
    }

    @Override
    public String toString() {
        return "Pig{" +
                "id=" + id +
                '}';
    }
}

package com.scx040407.untitled.practice2.gen.test;

import java.util.ArrayList;
import java.util.List;

public class Te<T> {
    private final int SIZE = 100;
    Class<T> kind;

    public void f(Object arg) {
//        if (arg instanceof T) {} //can't compile 需要知道类型确切信息
//        T var = new T();
        if (kind.isInstance(arg)) { //动态的isInstance
            System.out.println("kind ...");
        }
    }


    public static void main(String[] args) {

    }
}

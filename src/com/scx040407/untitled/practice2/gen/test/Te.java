package com.scx040407.untitled.practice2.gen.test;

import java.util.ArrayList;
import java.util.List;

public class Te<T> {
    private final int SIZE = 100;
    Class<T> kind;

    public void f(Object arg) {
//        if (arg instanceof T) {} //can't compile ��Ҫ֪������ȷ����Ϣ
//        T var = new T();
        if (kind.isInstance(arg)) { //��̬��isInstance
            System.out.println("kind ...");
        }
    }


    public static void main(String[] args) {

    }
}

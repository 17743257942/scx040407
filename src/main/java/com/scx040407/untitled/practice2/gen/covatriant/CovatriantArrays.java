package com.scx040407.untitled.practice2.gen.covatriant;

import java.util.ArrayList;
import java.util.List;

public class CovatriantArrays {
    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonason();
        try {
            fruits[0] = new Fruit();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            fruits[0] = new Orange();
        } catch (Exception e) {
            System.out.println(e);
        }

        // ���ͼ���<? extends Fruit>������add������get
        // ԭ�򣺾�������Ͳ���ȷ�����ܷ��ĵ���������Ӷ���
        List<? extends Fruit> fruits1 = new ArrayList<Apple>();
//        fruits1.add(new Apple()); //error
        fruits1.add(null);
        System.out.println(fruits1.get(0));
    }
}

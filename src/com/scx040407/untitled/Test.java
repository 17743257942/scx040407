package com.scx040407.untitled;

import com.scx040407.untitled.practice.InnerClassTest.Sequence;
import com.scx040407.untitled.practice4.io.IOUtilTest1;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws Exception {
//        test3();
    }

    private static void test3() throws IOException {
        IOUtilTest1.copyFile(new File("d:\\zhouyi.txt"), new File("zhouyi2.txt"));
    }

    public static void test2() throws Exception {
        IOUtilTest1.readFile("D:/zhouyi.txt");
    }

    private static void test1() {
        String a = "aaa";
        System.out.println(a);

        System.out.println(Season.SPRING);

        Integer i1 = 111;
        Integer i2 = 111;
        System.out.println(i1.equals(i2));
        System.out.println(i1==i2);

        String str = "a,b,c,d,,";
        String[] strs = str.split(",");
        System.out.println(strs.length);
        for (String s : strs) {
            System.out.println(s);
        }

        for (int i = 0; i < 20; i++) {
            Random rand = new Random(47);
            System.out.println(i + "  " + rand.nextInt());
        }
        System.out.println(new Person(2,"aa").equals(new Person(2, "aa")));
        System.out.println(new Person(2,"aa").hashCode());
        System.out.println(new Person(2,"aa").hashCode());
        System.out.println(new Person(2,"aa") +"  "+ new Person(2,"aa"));
    }

}

package com.scx040407.untitled.practice2.gen.test;

import com.scx040407.untitled.practice2.gen.covatriant.Apple;
import com.scx040407.untitled.practice2.gen.covatriant.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompilerfIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple) flist.get(0);
        System.out.println(flist.contains(a));
        System.out.println(flist.indexOf(a));
        List<Apple> l1 = new ArrayList<>();
        l1.add(new Apple());
        List<Fruit> l2 = new ArrayList<>();
        l2.add(new Apple());
        List<String> l3 = new ArrayList<>();
        l3.add("asadf");
        flist = l1;
        flist = l2;
//        flist = l3; //error

    }
}

package com.scx040407.untitled.practice2.gen.test;

public class GGTest {


    public static void main(String[] args) {
        GG gg = new GG<String>() {

            @Override
            public String ff() {
                return "ff";
            }

            @Override
            public String gg() {
                return "gg";
            }

            @Override
            public String toString() {
                return "asdfasdf";
            }
        };

        System.out.println(gg + " " + gg.ff() + " " + gg.gg());
    }
}

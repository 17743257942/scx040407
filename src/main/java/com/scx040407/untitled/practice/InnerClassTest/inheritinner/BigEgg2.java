package com.scx040407.untitled.practice.InnerClassTest.inheritinner;

public class BigEgg2 extends Egg2 {
    public class Yolk extends Egg2.Yolk {
        public Yolk() {
            System.out.println("BigEgg2.yolk()");
        }

        @Override
        public void f() {
            System.out.println("BigEgg2.yolk().f()");
        }
    }

    public BigEgg2() {
        insertYolk(new Yolk());
    }

    public static void main(String[] args) {
        Egg2 e2 = new BigEgg2(); //Egg2.yolk() new Egg2
        e2.g();
    }

}

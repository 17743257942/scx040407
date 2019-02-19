package com.scx040407.untitled.practice.InnerClassTest.inheritinner;

public class Egg2 {
    public Egg2() {
        System.out.println("new Egg2");
    }

    private Person p = new Person(); // 新建对象的动作会先于本类构造执行

    private Yolk y = new Yolk();


    protected class Yolk {
        public Yolk() {
            System.out.println("Egg2.yolk()");
        }
        public void f() {
            System.out.println("Egg2.yolk().f()");
        }
    }


    public void insertYolk(Yolk yy) {
        y = yy;
    }
    public void g() {
        y.f();
    }
}

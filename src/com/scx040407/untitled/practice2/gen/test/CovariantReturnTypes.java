package com.scx040407.untitled.practice2.gen.test;

public class CovariantReturnTypes {
    void test(DerivedGetter d) {
        Derived d2 = d.get();
    }

    public static void main(String[] args) {
        CovariantReturnTypes c = new CovariantReturnTypes();
        c.test(new DerivedGetter() {
            @Override
            public Derived get() {
                return new Derived();
            }
        });
    }
}

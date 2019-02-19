package com.scx040407.untitled.practice.nestedInterfaces;

public class NestingInterfaces {
    public class BImpl implements A.B {
        @Override
        public void f() {

        }
    }

    class CImpl implements A.C {

        @Override
        public void f() {

        }
    }

    class EImpl implements E {

        @Override
        public void g() {

        }
    }

    class EGImpl implements E.G {

        @Override
        public void f() {

        }
    }

    class EImpl2 implements E {

        @Override
        public void g() {

        }

        class EG implements E.G {

            @Override
            public void f() {

            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        a.receiveD(a.getD());
        A.DImpl ad = a.new DImpl();
        A.CImpl2 c2 = new A.CImpl2();
        A.C ac = a.new CImpl();
        E.G eg = new NestingInterfaces().new EGImpl();
    }


}

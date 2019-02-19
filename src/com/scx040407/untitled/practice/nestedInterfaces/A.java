package com.scx040407.untitled.practice.nestedInterfaces;

public class A {

    interface B {
        void f();
    }

    public class BImpl implements B{

        @Override
        public void f() {

        }
    }

    public class BImpl2 implements B{

        @Override
        public void f() {

        }
    }

    public interface C {
        void f();
    }

    class CImpl implements C {

        @Override
        public void f() {

        }
    }

    static class CImpl2 implements C {

        @Override
        public void f() {

        }
    }

    private interface D {
        void f();
    }

    class DImpl implements D {

        @Override
        public void f() {

        }
    }

    private class DImpl2 implements D {

        @Override
        public void f() {
            System.out.println("DImpl2 implements D");
        }
    }

    public D getD() {
        return new DImpl2();
    }

    private D dRef;

    public void receiveD(D d) {
        dRef = d;
        dRef.f();
    }
}

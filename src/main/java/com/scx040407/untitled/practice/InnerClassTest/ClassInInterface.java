package com.scx040407.untitled.practice.InnerClassTest;

public interface ClassInInterface {
    void howdy();

    class Test implements ClassInInterface {

        @Override
        public void howdy() {
            System.out.println("HowDy!");
        }

//        public static void main(String[] args) {
//            new Test().howdy();
//        }
    }
}

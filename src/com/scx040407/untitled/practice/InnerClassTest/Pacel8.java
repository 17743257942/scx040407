package com.scx040407.untitled.practice.InnerClassTest;

/**
 * ��������������ڲ���
 */
public class Pacel8 {
    public Wrapping wrapping(int x){
        return new Wrapping(x){
            public int value(){
                return super.value() * 47;
            }
        };
    }

    public static void main(String[] args) {
        Pacel8 p = new Pacel8();
        Wrapping w = p.wrapping(10);
        System.out.println(w.value());
    }
}

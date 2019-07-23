package com.scx040407.untitled.practice5.test;

/**
 * 1，加载到虚拟机的时候要赋默认值，count1=0 count2=0
 * 2，按顺序调用静态代码块和静态变量赋值：
 *      new StaticTest() 走到构造函数  1 1
 *      继续往下走 count1不变，count2被赋值成0
 *
 *
 * 对象创建：
 * 1 分配内存
 * 2 成员变量赋默认值
 * 3 成员变量初始化（构造代码块+赋值语句）
 * 4 构造函数
 *
 */
public class StaticTest {

    private static StaticTest staticTest = new StaticTest();
    public static int count1;
    public static int count2 = 0;

    private StaticTest() {
        count1++;
        count2++;
    }

    public static StaticTest getInstance() {
        return staticTest;
    }


    public static void main(String[] args) {

        StaticTest s = StaticTest.getInstance();
        System.out.println(StaticTest.count1);
        System.out.println(StaticTest.count2);


    }

}

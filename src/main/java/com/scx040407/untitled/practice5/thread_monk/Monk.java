package com.scx040407.untitled.practice5.thread_monk;

import java.util.Random;

/**
 * 和尚类，30个和尚，每个最多吃5个馒头，最少吃一个；
 */
public class Monk extends Thread {
    private int count; //已经吃了多少馒头
    private Box box; // 篮子
    private String name; //和尚名字
    public static int MAX = 5; //最大吃馒头数

    //获取已经吃了多少馒头
    public int getCount() {
        return count;
    }

    //构造方法
    public Monk(String name, Box box) {
        this.name = name;
        this.box = box;
    }

    @Override
    public void run() {

        while (true) {
            // 拿到篮子里的馒头数量
            int n = box.getMantou(this);

            // 吃馒头的时间
            try {
                Thread.sleep(new Random().nextInt(5));
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 如果篮子里馒头为0，返回；否则吃一个
            if (n == 0) {
                System.out.println(name + "不能吃了，已经没有了" );
                return;
            } else if (n == -1) {
                System.out.println(name + "不能吃了，达到最大份额" );
                return;
            } else {
                count++;
                System.out.println(name + ":  " + count + "   还有" + (n - 1) + "个馒头");
            }

        }

    }
}




package com.scx040407.untitled.practice5.thread_monk;

/**
 * 馒头箱子，有100个馒头
 */
public class Box {
    private int count = 100;

    public synchronized int getMantou(Monk m) {

        int mcount = m.getCount();

        // 没有馒头了就返回0
        if (count == 0) {
            return 0;
        }

        //如果和尚吃了5个了，就告诉他已经达到最大份额
        if (mcount == Monk.MAX) {
            return -1;
        }

        //调用一次就说明拿了一个馒头
        int curcount = count;
        count--;

        // 剩最后30个馒头，为了保证每个人都能吃到，所以拿过馒头的都等待
        if (count > 70) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            this.notifyAll();
        }


        return curcount;
    }


}

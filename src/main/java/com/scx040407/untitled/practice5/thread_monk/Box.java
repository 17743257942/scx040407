package com.scx040407.untitled.practice5.thread_monk;

/**
 * ��ͷ���ӣ���100����ͷ
 */
public class Box {
    private int count = 100;

    public synchronized int getMantou(Monk m) {

        int mcount = m.getCount();

        //������г���5���ˣ��͸�����������û����ͷ��
        if (mcount == Monk.MAX) {
            return 0;
        }

        //����һ�ξ�˵������һ����ͷ
        int curcount = count;
        count--;

        // ʣ���30����ͷ��Ϊ�˱�֤ÿ���˶��ܳԵ��������ù���ͷ�Ķ��ȴ�
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

package com.scx040407.untitled.practice5.thread_monk;

import java.util.Random;

/**
 * �����࣬30�����У�ÿ������5����ͷ�����ٳ�һ����
 */
public class Monk extends Thread {
    private int count; //�Ѿ����˶�����ͷ
    private Box box; // ����
    private String name; //��������
    public static int MAX = 5; //������ͷ��

    //��ȡ�Ѿ����˶�����ͷ
    public int getCount() {
        return count;
    }

    //���췽��
    public Monk(String name, Box box) {
        this.name = name;
        this.box = box;
    }

    @Override
    public void run() {

        while (true) {
            // �õ����������ͷ����
            int n = box.getMantou(this);

            // ����ͷ��ʱ��
            try {
                Thread.sleep(new Random().nextInt(5));
            } catch (Exception e) {
                e.printStackTrace();
            }
            // �����������ͷΪ0�����أ������һ��
            if (n == 0) {
                System.out.println(name + "���ܳ��ˣ��Ѿ�û����" );
                return;
            } else if (n == -1) {
                System.out.println(name + "���ܳ��ˣ��ﵽ���ݶ�" );
                return;
            } else {
                count++;
                System.out.println(name + ":  " + count + "   ����" + (n - 1) + "����ͷ");
            }

        }

    }
}




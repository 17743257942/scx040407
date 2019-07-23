package com.scx040407.untitled.practice5.test;

/**
 * 1�����ص��������ʱ��Ҫ��Ĭ��ֵ��count1=0 count2=0
 * 2����˳����þ�̬�����;�̬������ֵ��
 *      new StaticTest() �ߵ����캯��  1 1
 *      ���������� count1���䣬count2����ֵ��0
 *
 *
 * ���󴴽���
 * 1 �����ڴ�
 * 2 ��Ա������Ĭ��ֵ
 * 3 ��Ա������ʼ������������+��ֵ��䣩
 * 4 ���캯��
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

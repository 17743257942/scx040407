package com.scx040407.untitled;

import java.util.Arrays;
/**
 * 取前三名的成绩
 *
 */
public class HelloWorld {

    //完成 main 方法
    public static void main(String[] args) {
        int[] scores = new int[]{89 , -23 , 64 , 91 , 119 , 52 , 73};
        threeResults(scores);
    }

    //定义方法完成成绩排序并输出前三名的功能

    public static void threeResults(int[] scores)
    {
        if( scores.length==0)
        {
           return;
        }
        Arrays.sort(scores);
        int count = 0 ;
        for (int i = scores.length-1;i>0;i--)
        {
            if(count ==3)
            {
                break;
            }
            if(scores[i]>=0 && scores[i]<=100)
            {
                System.out.println(scores[i]);
                count++;
            }
        }
    }

}
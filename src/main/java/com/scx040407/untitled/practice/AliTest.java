package com.scx040407.untitled.practice;

public class AliTest {
    public static void main(String[] args) {
        int num = 97 ;
        char c = (char) num ;
        System.out.println(c) ;

        int i = 1 ;
        int j = i++ ;
        if((i==(++j))&&((i++)==j))     {
            i += j ;
        }
        System.out.println("i = "+i);

        if ((22 == 23) && (100 / 0 == 0))
            System.out.println("运算没有问题。");
        else
            System.out.println("没有报错");

        int num2 = 2147483647 ;
        long temp = num2 + 2L ;
        System.out.println(temp) ;

        long num3 = 100 ;
        int x = (int) (num3 + 2);  //类型转换
        System.out.println(x) ;

        int num4 = 2147483647 ;
        num4 += 3L ;
        System.out.println(num4) ;

        System.out.println(Integer.MAX_VALUE);

        int num5 = 2147483647 ;
        num5 = num5 + 1 ;
        System.out.println(num5) ;

        int num6 = 50 ;
        num6 = num6 ++ * 2 ;
        System.out.println(num6) ;


    }
}

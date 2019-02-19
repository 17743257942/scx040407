package com.scx040407.untitled;

import java.io.File;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Date;

public class ZhouYi {
    public static void main(String[] args) throws UnsupportedEncodingException {
        int i1=411;//输入一个三位数 变动爻
        int i2=847;//输入一个三位数 上卦
        int i3=996;//输入一个三位数 下卦
        String s2="2018工作运？"+new Date().toLocaleString();//在这里输入为何事求的卦
        String s=s2+"==变动爻:"+(i1%6==0?6:i1%6)+",上卦:"+(i2%8==0?8:i2%8)+
                ",下卦:"+(i3%8==0?8:i3%8)+"\r\n"+"----------------------"+"\r\n";
        System.out.println(s);
        File file=new File("D:/zhouyi.txt");
        try {
            Writer writer=new FileWriter(file, true);
            writer.write(s, 0, s.length());
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

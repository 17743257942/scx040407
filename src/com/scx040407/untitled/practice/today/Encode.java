package com.scx040407.untitled.practice.today;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Encode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String strTest = "?=abc?中%1&2<3,4>";
        strTest = URLEncoder.encode(strTest, "UTF-8");//转码
        System.out.println(strTest);
        strTest = URLDecoder.decode(strTest,"UTF-8");//解码
        System.out.println(strTest);
    }
}

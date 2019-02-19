package com.scx040407.untitled.practice.state;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);  // 2018-01-10T13:50:52.427Z

        System.out.println(Instant.parse("2018-01-10T13:50:52.427Z"));

        System.out.println(Instant.EPOCH);
        System.out.println(Instant.MAX);
        System.out.println(Instant.MIN);

        System.out.println(instant.getEpochSecond());
        double curYear = 1970L+instant.getEpochSecond()/3600L/24L/365L;
        System.out.println(curYear);
        System.out.println(System.currentTimeMillis());

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime); // 2018-01-10T21:58:16.902

        String s = "yyyy-MM-dd HH:mm:ss";
        /**
         * full 2018年1月10日 星期三
         * long 2018年1月10日
         * MEDIUM 2018-1-10
         * SHORT 18-1-10
         */
        FormatStyle formatStyle = FormatStyle.FULL;
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(formatStyle);
        formatter.format(localDateTime);
        System.out.println(formatter.format(localDateTime));


    }
}

package com.han.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUtil {
    public static void main(String[] args) {
        LocalDateTime localDateTime= LocalDateTime.now();

//        System.out.println(localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
        //后来的添加
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyMMddHHmmssSSS");
//        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern(DateTimeFormatter.);

        String strDate2 = dtf2.format(localDateTime);

        System.out.println(strDate2);
        //第一次commit   第二次commit
        //第三次commit


        // 后续  commit
    }
}

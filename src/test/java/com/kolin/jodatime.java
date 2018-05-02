package com.kolin;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @Author jingkeling
 * @Date 2018/5/2 19:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class jodatime {


    @Test
    public void test () {
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

        DateTime dateTime = DateTime.parse("2012-12-21 23:22:45", format);
        final Calendar calendar = dateTime.toCalendar(Locale.CHINESE);


        DateTime dateTime1 = new DateTime(new Date());
        System.out.println("DateTime: "+dateTime1);

        String s = dateTime1.toString("yyyy/MM/dd HH:mm:ss EE");
        System.out.println("String: "+s);
        final String s1 = dateTime1.toString("yyyy/MM/dd HH:mm:ss EE", Locale.CHINESE);
        System.out.println("中国："+s1);
        final String s2 = dateTime.toString("yyyy/MM/dd HH:mm:ss EE", Locale.CHINESE);
        System.out.println("日本： "+s2);


    }
}

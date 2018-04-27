package com.kolin.不可变对象;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author jingkeling
 * @Date 2018/4/27 21:48
 */
public class StringExample {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        test1();

    }

    public static void test1() {
        HashSet set = new HashSet<String>();
        String sb1 = new String("aaa");
        String sb2 = new String("aaabbb");
        set.add(sb1);
        set.add(sb2);

        String sb3 = sb1;
        sb3 += "bbb";
        sb1 += "ccc";
        System.out.println(set);
        System.out.println(sb1);
    }

    public static void test2() throws NoSuchFieldException, IllegalAccessException {
        String s="123";
        Field valueArray=String.class.getDeclaredField("value");
        valueArray.setAccessible(true);
        char[] array=(char[]) valueArray.get(s);
        array[0]='2';
        System.out.println(s);

    }
}

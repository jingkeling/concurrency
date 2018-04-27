package com.kolin.安全发布对象;

/**
 * 饿汉模式
 * 线程安全的
 * @Author jingkeling
 * @Date 2018/4/27 20:01
 */
public class SingletonExample2 {

    private SingletonExample2() {

    }

    /**
     * 初始化时就构造
     */
    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance() {
        return instance;
    }

}

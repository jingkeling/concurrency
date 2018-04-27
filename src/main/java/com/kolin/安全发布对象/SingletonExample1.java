package com.kolin.安全发布对象;

/**
 * 懒汉模式
 * @Author jingkeling
 * @Date 2018/4/27 20:01
 */
public class SingletonExample1 {

    private SingletonExample1 () {

    }

    private static SingletonExample1 instance = null;

    /**
     * 调用方法才返回
     * @return
     */
    public static SingletonExample1 getInstance() {
        if (instance == null) {
            return new SingletonExample1();
        }
        return instance;
    }

}

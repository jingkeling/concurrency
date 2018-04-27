package com.kolin.安全发布对象;

/**
 * 枚举  线程安全 推荐做法
 * @Author jingkeling
 * @Date 2018/4/27 20:01
 */
public class SingletonExample5 {

    private SingletonExample5() {

    }

    public static SingletonExample5 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample5 singleton;

        //JVM保证这个方法绝对值只调用一次
        Singleton() {
            singleton = new SingletonExample5();
        }

        public SingletonExample5 getInstance() {
            return singleton;
        }
    }

}

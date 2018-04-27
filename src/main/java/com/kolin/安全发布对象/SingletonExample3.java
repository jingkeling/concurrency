package com.kolin.安全发布对象;

/**
 * 懒汉模式　＋　双重锁 线程还是不安全
 * @Author jingkeling
 * @Date 2018/4/27 20:01
 */
public class SingletonExample3 {

    private SingletonExample3() {

    }

    private static SingletonExample3 instance = null;


    /**
     * 指令重拍
     * 1、memory = allocate() 分配对戏那的内存
     * 2、ctorinstance() 初始化对象
     * 3、instance = memory() 设置instance指向刚分配的内存
     *
     * JVM和CPU优化，发生了指令重排
     * 1、memory = allocate() 分配对戏那的内存
     * 3、instance = memory() 设置instance指向刚分配的内存
     * 2、ctorinstance() 初始化对象
     */
    public static SingletonExample3 getInstance() {
        /**
         * 如果不用双重锁，每次进来都加锁
         */
        if (instance == null) {
            synchronized (SingletonExample3.class) {
                if (instance == null) {
                    instance = new SingletonExample3();
                }
            }
            return new SingletonExample3();
        }
        return instance;
    }

}

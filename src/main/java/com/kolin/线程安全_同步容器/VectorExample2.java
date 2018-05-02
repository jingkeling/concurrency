package com.kolin.线程安全_同步容器;


import lombok.experimental.var;

import java.util.Vector;

/**
 *
 * @Author jingkeling
 * @Date 2018/5/2 21:13
 */
class VectorExample2 {

    /*
    这里的线程不安全跟同步容器本身没关系，跟逻辑代码不严谨有关
    也证明了两个线程安全的容器并不能决定他们之间的代码是线程安全的
     */

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args){
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }


        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    vector.get(i);
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    vector.remove(i);
                }
            }
        };

        thread1.start();
        thread2.start();

    }


}
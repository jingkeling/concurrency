package com.kolin.不可变对象;


import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.Collections;
import java.util.Map;

/**
 * @Author jingkeling
 * @Date 2018/4/27 20:54
 */
@Slf4j
public class UnmodifiableExample1 {

    /**
     * Collections.unmodifiableXXX 方法，不可变对象
     */

    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 1);
        map.put(2, 3);
        map.put(3, 4);
        //java的Collections
        map = Collections.unmodifiableMap(map);

    }

    public static void main(String[] args){
        //不可修改，运行后UnsupportedOperationException
        map.put(1, 2);
        System.out.println("--"+map.get(1));

    }
}

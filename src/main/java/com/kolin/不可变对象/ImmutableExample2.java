package com.kolin.不可变对象;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Author jingkeling
 * @Date 2018/4/27 20:54
 */
@Slf4j
public class ImmutableExample2 {

    /**
     * Guava的ImmutableXXX方法 不可变对象
     */

    private final static List list = ImmutableList.of(1, 2, 3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1, 2, 3, 5);

    private final static ImmutableMap<Integer, Integer> map1 = ImmutableMap.<Integer, Integer>builder()
            .put(1, 2).put(2, 3).build();



    public static void main(String[] args){
        map1.put(3, 5);
    }
}

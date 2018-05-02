package com.kolin.线程安全_并发容器;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.kolin.uitls.ExecutorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.*;
import java.util.concurrent.*;

/**
 * @Author jingkeling
 * @Date 2018/5/2 23:05
 */
@Slf4j
public class Demo {


    private static int clientTotal = 5000;


    /**
     * list
     */
    private static List list = new ArrayList<Integer>();
    private static List<Integer> list1 = new CopyOnWriteArrayList<>();

    /**
     * map
     */
    private static Map<Integer, Integer> map = new HashMap<>();
    private static Map<Integer, Integer> map1 = new ConcurrentHashMap<>();
    private static Map<Integer, Integer> map2 = new ConcurrentSkipListMap<>();

    /**
     * set
     */
    private static Set<Integer> set = Sets.newHashSet();
    private static Set<Integer> set1 = new CopyOnWriteArraySet<>();
    private static Set<Integer> set2 = new ConcurrentSkipListSet<>();


    public static void main(String[] args){
        final ThreadPoolTaskExecutor executor = ExecutorUtils.getExecutor();


        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executor.execute(()-> update(count));
        }

        log.info("list长度是 {}", list.size());
        log.info("list1长度是 {}", list1.size());
        log.info("-------------------------------");
        log.info("map长度是 {}", map.size());
        log.info("map1长度是 {}", map1.size());
        log.info("map2长度是 {}", map2.size());
        log.info("-------------------------------");
        log.info("set长度是{}", set.size());
        log.info("set1长度是{}", set1.size());
        log.info("set2长度是{}", set2.size());

        executor.shutdown();
    }

    public static void update(int i) {
        list.add(i);
        list1.add(i);

        map.put(i, i);
        map1.put(i, i);
        map2.put(i, i);

        set.add(i);
        set1.add(i);
        set2.add(i);
    }
}

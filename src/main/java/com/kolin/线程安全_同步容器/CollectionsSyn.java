package com.kolin.线程安全_同步容器;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.kolin.uitls.ExecutorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.*;

/**
 * 对比线程安全的容器和不安全的
 * @Author jingkeling
 * @Date 2018/5/2 21:32
 */
@Slf4j
public class CollectionsSyn {


    private static int clientTotal = 5000;


    /**
     * list
     */
    private static List list = new ArrayList<Integer>();
    private static List list1 = new Vector<Integer>();
    private static List<Integer> list2 = Collections.synchronizedList(Lists.newArrayList());

    /**
     * map
     */
    private static Map<Integer, Integer> map = new HashMap<>();
    private static Map<Integer, Integer> map1 = new Hashtable<>();
    private static Map<Integer, Integer> map2 = Collections.synchronizedMap(Maps.newHashMap());

    /**
     * set
     */
    private static Set<Integer> set = Sets.newHashSet();
    private static Set<Integer> set1 = Collections.synchronizedSet(Sets.newHashSet());

    public static void main(String[] args){
        final ThreadPoolTaskExecutor executor = ExecutorUtils.getExecutor();


        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executor.execute(()-> update(count));
        }

        log.info("list长度是 {}", list.size());
        log.info("list1长度是 {}", list1.size());
        log.info("list2长度是 {}", list2.size());
        log.info("-------------------------------");
        log.info("map长度是 {}", map.size());
        log.info("map1长度是 {}", map1.size());
        log.info("map2长度是 {}", map2.size());
        log.info("-------------------------------");
        log.info("set长度是{}", set.size());
        log.info("set1长度是{}", set1.size());

        executor.shutdown();
    }

    public static void update(int i) {
        list.add(i);
        list1.add(i);
        list2.add(i);

        map.put(i, i);
        map1.put(i, i);
        map2.put(i, i);

        set.add(i);
        set1.add(i);
    }

}

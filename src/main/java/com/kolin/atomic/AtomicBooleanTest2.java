package com.kolin.atomic;

import com.kolin.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 测试
 * @Author jingkeling
 * @Date 2018/4/14 21:24
 */
@Slf4j
@ThreadSafe
public class AtomicBooleanTest2 {
    /**
     * 请求总数
     */
    public static int clientTotal = 5000;
    /**
     * 同时并发执行的线程数
     */
    public static int threadTotal = 200;

    private static AtomicBoolean isHappened = new AtomicBoolean(false);

    public static void main(String[] args) throws Exception {
        //手动穿件线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 200, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024),
                (r) -> {
                    Thread t = new Thread(r);
                    System.out.println("生成线程 " + t);
                    return t;
                });
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal ; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        threadPoolExecutor.shutdown();
        log.info("isHappened:{}", isHappened.get());
    }

    private static void test() {
        if (isHappened.compareAndSet(false, true)) {
            log.info("my execute");
        }
    }
}

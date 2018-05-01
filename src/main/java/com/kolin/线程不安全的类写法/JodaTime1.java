package com.kolin.线程不安全的类写法;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @Author jingkeling
 * @Date 2018/5/1 23:09
 */
@Slf4j
public class JodaTime1 {

    /**
     * 请求总数
     */
    public static int clientTotal = 5000;

    /**
     * joda-time类。线程安全
     */
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyyMMdd");

    public static void main(String[] args) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(200);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("kelingExecutor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        for (int i = 0; i < clientTotal ; i++) {
            final int count = i;
            executor.execute(() ->
                update(count)
            );
          /*  executor.execute(new Runnable() {
                @Override
                public void run() {
                    update(count);
                }
            });*/

        }

    }

    private static void update(int i) {
        log.info("{},{}",i, DateTime.parse("20180208", dateTimeFormatter).toDate() );
    }


}

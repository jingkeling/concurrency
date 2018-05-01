package com.kolin.ConfigurationProcessor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * 执行
 * @Author jingkeling
 * @Date 2018/5/1 22:10
 */
@Component
public class DoSomeThing {




    @Async(value = "myTaskAsyncPool")
    public void produc() {
        System.out.println("任务产生了");
    }
    
    @Async("myTaskAsyncPool")
    public void comsumerTask(){
        System.out.println("任务消费");
    }
}

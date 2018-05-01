package com.kolin.ConfigurationProcessor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.bv.time.futureorpresent.AbstractFutureOrPresentInstantBasedValidator;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.AssertTrue;

/**
 * 新建线程参数装载类
 * @Author jingkeling
 * @Date 2018/5/1 21:57
 */
@ConfigurationProperties(prefix = "spring.task.pool")
@Data
@Configuration
@NoArgsConstructor
@AllArgsConstructor
public class TaskThreadPoolConfig {

    private int corePoolSize;

    private int maxPoolSize;

    private int keepAliveSeconds;

    private int queueCapacity;


}

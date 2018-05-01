package com.kolin.ConfigurationProcessor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author jingkeling
 * @Date 2018/5/1 23:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DoSomeThingTest {

    @Autowired
    private DoSomeThing doSomeThing;

    @Test
    public void produc() {

        doSomeThing.produc();
        doSomeThing.comsumerTask();

    }

    @Test
    public void comsumerTask() {
    }
}
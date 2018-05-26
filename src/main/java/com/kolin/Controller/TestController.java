package com.kolin.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jingkeling
 * @Date 2018/4/14 19:45
 */
@RestController
@Slf4j
public class TestController {




    /*
    [nio-8080-exec-1]
[nio-8080-exec-4]
[nio-8080-exec-2]
[nio-8080-exec-5]
[nio-8080-exec-3]
[nio-8080-exec-6]
[nio-8080-exec-7]
[io-8080-exec-12]
[io-8080-exec-10]
[io-8080-exec-11]
[nio-8080-exec-4]
[io-8080-exec-19]
[nio-8080-exec-4]
     */
    /**
     *
     * @return
     */
    @RequestMapping("/test")
    public String test() {
        log.info("1");
        return "test";
    }

}

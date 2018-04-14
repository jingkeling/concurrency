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


    @RequestMapping("/test")
    public String test() {
        return "test";
    }

}

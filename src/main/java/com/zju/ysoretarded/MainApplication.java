package com.zju.ysoretarded;

import com.zju.ysoretarded.controller.DemoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zcz
 * @CreateTime 2020/2/9 23:05
 */
//@EnableAutoConfiguration
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }
}

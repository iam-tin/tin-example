package com.tin.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * title: Main
 * <p>
 * description: spring容器启动类
 *
 * @author tin @看点代码再上班 on 2021/1/10 下午2:08
 */
@SpringBootApplication
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        LOGGER.info("容器启动成功... ");
    }
}

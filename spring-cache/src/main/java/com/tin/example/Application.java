package com.tin.example;

import com.tin.example.service.MyGuavaCacheService;
import com.tin.example.service.SpringCacheService;
import com.tin.example.util.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * title: Application
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2021/12/25 上午10:27
 */
@SpringBootApplication
@EnableCaching
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        LOGGER.info("容器启动成功... ");

        SpringCacheService springCacheService = SpringContextUtil.getBean(SpringCacheService.class);
        springCacheService.query();

//        MyGuavaCacheService myGuavaCacheService = SpringContextUtil.getBean(MyGuavaCacheService.class);
//        myGuavaCacheService.query();
    }
}

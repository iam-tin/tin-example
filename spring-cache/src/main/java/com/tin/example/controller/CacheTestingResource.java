package com.tin.example.controller;

import com.tin.example.service.SpringCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * title: 测试缓存
 * <p>
 * description:
 *
 * @author tin @看点代码再上班 on 2021/1/10 下午2:24
 */
@RestController
@RequestMapping("/cache/v1")
public class CacheTestingResource {
    private static Logger LOGGER = LoggerFactory.getLogger(CacheTestingResource.class);

    @Autowired
    private SpringCacheService springCacheService;

    /**
     * spring cache test
     *
     * @return
     */
    @GetMapping("/normal-test")
    public String findBook() {
        LOGGER.info("start to find one book...");
        springCacheService.query();
        return "ok";
    }

    /**
     * spring cache test
     *
     * @return
     */
    @GetMapping("/jdkaop-test")
    public String findBook2() {
        LOGGER.info("start to find one book...");
        springCacheService.testing4JdkAop();
        return "ok";
    }
}

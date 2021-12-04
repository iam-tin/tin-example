package com.tin.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * title: ExampleResource
 * <p>
 * description:
 *
 * @author tin @看点代码再上班 on 2021/1/10 下午2:24
 */
@RestController
@RequestMapping("/example/v1")
public class ExampleResource {
    private static Logger LOGGER = LoggerFactory.getLogger(ExampleResource.class);

    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        LOGGER.info("访问hell接口...");
        return "hello @" + name +" !";
    }
}

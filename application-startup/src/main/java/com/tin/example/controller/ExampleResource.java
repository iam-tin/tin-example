package com.tin.example.controller;

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
@RequestMapping("/v1")
public class ExampleResource {

    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return "hello @" + name +" !";
    }
}

package com.tin.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * title: ExampleResource
 * <p>
 * description:
 *
 * @author tin @看点代码再上班 on 2021/1/10 下午2:24
 */
@RestController
@RequestMapping("/varify/v1")
public class VarifyResource {
    private static Logger LOGGER = LoggerFactory.getLogger(VarifyResource.class);

    private static List<String> VALID_IPHONE =  new ArrayList<>();
    static {
        VALID_IPHONE.add("15012588595");
        VALID_IPHONE.add("11111111111");
    }

    @GetMapping("/varify")
    public String varify(@RequestParam("phone") String phone) {
        if (VALID_IPHONE.contains(phone)){
            return "ok";
        }
        return "wrong phone number !";
    }
}

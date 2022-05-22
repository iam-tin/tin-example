package com.tin.example.dubbo.demo.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.tin.example.dubbo.demo.domain.Gift;
import com.tin.example.dubbo.demo.facade.GiftFacade;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * title: Main
 * <p>
 * description: spring容器启动类
 *
 * @author tin @看点代码再上班 on 2022/2/27 下午2:08
 */
@SpringBootApplication
@Slf4j
public class ConsumerApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerApplication.class);
    private static JsonMapper jsonMapper = new JsonMapper();

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();
        LOGGER.info("容器启动成功... ");
        gift(context);
        latch.await();
    }

    private static void gift(ClassPathXmlApplicationContext context) {
        GiftFacade giftFacade = context.getBean("giftFacade", GiftFacade.class);
        Gift gift = giftFacade.give("tin@【看点代码再上班】", "《设计模式之禅》");
        try {
            log.info("get gift: {}", jsonMapper.writeValueAsString(gift));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

package com.tin.example.spring.log4j2;

import com.tin.example.TinSpringApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * title: AccountTest
 * <p>
 * description: log打码脱敏单元测试
 *
 * @author tin @看点代码再上班 on 2021/1/12 下午11:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TinSpringApplication.class)
public class AccountTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountTest.class);

    @Test
    public void test_account() {
        String name = "tin@看点代码再上班";
        String address = "莫斯科";
        String bankAccount = "4001967430001996634";
        long balance = 9000000;
        String phone = "18712883399";
        User tin = new User(name, address, bankAccount, balance, phone);
        LOGGER.info("i am 【{}】, here is my bank account: {}", tin.getName(), tin.getBankAccount());
    }
}

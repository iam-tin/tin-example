package com.tin.example.spring.log4j2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * title: User
 * <p>
 * description: 用户类
 *
 * @author tin @看点代码再上班 on 2021/1/12 下午11:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 用户名
     */
    private String name;
    /**
     * 地址
     */
    private String address;
    /**
     * 银行账号
     */
    private String bankAccount;
    /**
     * 余额，单位：分
     */
    private long balance;
    /**
     * 电话号码
     */
    private String phone;
}

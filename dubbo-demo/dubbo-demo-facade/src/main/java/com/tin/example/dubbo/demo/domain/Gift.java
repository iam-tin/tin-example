package com.tin.example.dubbo.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * title: Gift
 * <p>
 * description:礼物类
 *
 * @author tin @公众号【看点代码再上班】 on 2022/2/27 下午9:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gift {
    private String owner;
    private String giftName;
}

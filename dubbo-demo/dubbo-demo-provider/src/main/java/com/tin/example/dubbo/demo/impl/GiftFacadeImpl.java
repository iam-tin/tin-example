package com.tin.example.dubbo.demo.impl;

import com.tin.example.dubbo.demo.domain.Gift;
import com.tin.example.dubbo.demo.facade.GiftFacade;
import lombok.extern.slf4j.Slf4j;

/**
 * title: GiftFacadeImpl
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2022/2/27 下午5:26
 */
@Slf4j
public class GiftFacadeImpl implements GiftFacade {
    @Override
    public Gift give(String toSomeOne, String giftName) {
        log.info("hello {}, welcome to 公众号【看点代码再上班】", toSomeOne);
        return new Gift(toSomeOne, giftName);
    }
}

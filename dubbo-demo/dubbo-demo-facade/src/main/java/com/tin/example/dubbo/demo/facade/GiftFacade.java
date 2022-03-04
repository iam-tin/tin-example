package com.tin.example.dubbo.demo.facade;

import com.tin.example.dubbo.demo.domain.Gift;

/**
 * title: GiftFacade
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2022/2/27 下午5:25
 */
public interface GiftFacade {
    Gift give(String toSomeOne, String giftName);
}

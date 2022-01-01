package com.tin.example.library;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * title: BookStore
 * <p>
 * description:藏书仓库
 *
 * @author tin @公众号【看点代码再上班】 on 2021/12/25 上午11:17
 */
@Component
public class BookStore implements InitializingBean {
    private final List<BookEntity> bookEntityList = new ArrayList<>();

    /**
     * 模拟有1000本藏书的图书仓库
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        for (int i = 0; i < 1000; i++) {
            bookEntityList.add(new BookEntity(i, "00" + i + "号藏书" + "@公众号【看点代码再上班】", "第一排第" + i + "列"));
        }
    }

    public boolean hasBook() {
        return !CollectionUtils.isEmpty(bookEntityList);
    }

    public List<BookEntity> getBookStore() {
        return bookEntityList;
    }
}

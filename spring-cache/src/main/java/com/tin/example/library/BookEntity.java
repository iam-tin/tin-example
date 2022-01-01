package com.tin.example.library;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * title: BookEntity
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2021/12/25 上午11:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    /**
     * 藏书编号
     */
    private int number;
    /**
     * 书名
     */
    private String bookName;
    /**
     * 藏书地址
     */
    private String bookAddr;
}

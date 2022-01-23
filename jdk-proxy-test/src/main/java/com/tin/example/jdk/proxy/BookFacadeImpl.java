package com.tin.example.jdk.proxy;

/**
 * title: BookFacadeImpl
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2022/1/22 上午8:56
 */
public class BookFacadeImpl implements BookFacade {
    @Override
    public void addBook(String bookName) {
        System.out.println("添加书籍, bookName:" + bookName);
    }
}

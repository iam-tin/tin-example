package com.tin.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * title: LibraryService
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2021/12/25 上午10:58
 */
@Service
public class BookService extends AbstractLibraryService {

    @Autowired
    private BookStore bookStore;

    @Override
    public BookEntity findByBookName(String bookName) {
        //模拟查询耗时100毫秒
        sleep4Millis(100);

        if (!bookStore.hasBook()) {
            return null;
        }
        List<BookEntity> allBook = bookStore.getBookStore();
        for (BookEntity bookEntity : allBook) {
            if (bookEntity == null) {
                continue;
            }
            if (bookEntity.getBookName() != null && bookEntity.getBookName().contains(bookName)) {
                return bookEntity;
            }
        }
        return null;
    }

    @Cacheable("library")
    @Override
    public BookEntity findByBookNameWithSpringCache(String bookName) {
        return findByBookName(bookName);
    }
}

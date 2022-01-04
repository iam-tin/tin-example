package com.tin.example.impl;

import com.tin.example.facade.LibraryFacade;
import com.tin.example.library.BookEntity;
import com.tin.example.library.BookStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.tin.example.library.AbstractLibraryService.sleep4Millis;

/**
 * title: LibraryFacadeImpl
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2022/1/1 上午10:42
 */
@Service
public class LibraryFacadeImpl implements LibraryFacade {

    @Autowired
    private BookStore bookStore;

    @Cacheable("library")
    @Override
    public BookEntity findBookByNumber(int number) {
        sleep4Millis(100);
        if (!bookStore.hasBook()) {
            return null;
        }
        List<BookEntity> allBook = bookStore.getBookStore();
        for (BookEntity bookEntity : allBook) {
            if (bookEntity == null) {
                continue;
            }
            if (bookEntity.getNumber() == number) {
                return bookEntity;
            }
        }
        return null;
    }
}

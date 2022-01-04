package com.tin.example.facade;

import com.tin.example.library.BookEntity;

/**
 * title: LibraryFacade
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2022/1/1 上午10:39
 */
public interface LibraryFacade {
    BookEntity findBookByNumber(int number);
}

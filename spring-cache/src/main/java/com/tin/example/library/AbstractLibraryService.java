package com.tin.example.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * title: AbstractLibrary
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2021/12/25 上午11:06
 */
public abstract class AbstractLibraryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractLibraryService.class);

    public abstract BookEntity findByBookName(String bookName);

    public abstract BookEntity findByBookNameWithSpringCache(String bookName);

    /**
     * sleep for millis
     */
    public void sleep4Millis(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            LOGGER.error("sleep error. millis:{}", millis, e);
        }
    }
}

package com.tin.example.service;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Stopwatch;
import com.tin.example.facade.LibraryFacade;
import com.tin.example.library.BookEntity;
import com.tin.example.library.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * title: CacheRun
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2021/12/25 上午10:56
 */
@Service
public class SpringCacheService {

    @Autowired
    private BookService bookService;
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private LibraryFacade libraryFacade;

    public void query() {
        String bookName = "001号藏书r";
        Stopwatch stopwatch = Stopwatch.createStarted();
        BookEntity bookEntity = bookService.findByBookNameWithSpringCache(bookName);
        System.out.println("query:" + bookName
                + "\r\ncost:" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms"
                + "\r\nbook:" + JSON.toJSONString(bookEntity)
                + "\r\n------------------");

        bookName = "001号藏书";
        stopwatch.reset().start();
        bookEntity = bookService.findByBookNameWithSpringCache(bookName);
        System.out.println("query:" + bookName
                + "\r\ncost:" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms"
                + "\r\nbook:" + JSON.toJSONString(bookEntity)
                + "\r\n------------------");

        bookName = "002号藏书";
        stopwatch.reset().start();
        bookEntity = bookService.findByBookNameWithSpringCache(bookName);
        System.out.println("query:" + bookName
                + "\r\ncost:" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms"
                + "\r\nbook:" + JSON.toJSONString(bookEntity)
                + "\r\n------------------");

        bookName = "002号藏书";
        stopwatch.reset().start();
        bookEntity = bookService.findByBookNameWithSpringCache(bookName);
        System.out.println("query:" + bookName
                + "\r\ncost:" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms"
                + "\r\nbook:" + JSON.toJSONString(bookEntity)
                + "\r\n------------------");

        System.out.println("query:" + cacheManager.getCache("library"));

    }

    public void testing4JdkAop() {
        int bookNum = 0;
        Stopwatch stopwatch = Stopwatch.createStarted();
        BookEntity bookEntity = libraryFacade.findBookByNumber(bookNum);
        System.out.println("bookNumber:" + bookNum
                + "\r\ncost:" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms"
                + "\r\nbook:" + JSON.toJSONString(bookEntity)
                + "\r\n------------------");

        bookNum = 0;
        stopwatch.reset().start();
        bookEntity = libraryFacade.findBookByNumber(bookNum);
        System.out.println("bookNumber:" + bookNum
                + "\r\ncost:" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms"
                + "\r\nbook:" + JSON.toJSONString(bookEntity)
                + "\r\n------------------");
    }

}

package com.tin.example.service;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Stopwatch;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.tin.example.library.BookEntity;
import com.tin.example.library.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * title: CacheService
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2021/12/26 上午10:18
 */
@Service
public class MyGuavaCacheService implements InitializingBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyGuavaCacheService.class);
    private static LoadingCache<String, BookEntity> CACHE;

    @Autowired
    private BookService bookService;

    public void query() {
        String bookNamePrefix = "00";
        String bookNameSuffix = "号藏书";
        for (int i = 0; i < 3; i++) {
            String bookName = bookNamePrefix + i + bookNameSuffix;
            for (int j = 0; j < 2; j++) {
                queryFromCache(bookName);
            }
        }

        //查看缓存状态
        LOGGER.info("cache stats:{}", CACHE.stats().toString());
    }

    public void queryFromCache(String bookName) {
        try {
            Stopwatch stopwatch = Stopwatch.createStarted();
            BookEntity bookEntity = CACHE.get(bookName);
            LOGGER.info("query:{},cost:{}ms,book:{}",
                    bookName, stopwatch.elapsed(TimeUnit.MILLISECONDS), JSON.toJSONString(bookEntity));
        } catch (Exception e) {
            LOGGER.error("cache read error. bookName:{}", bookName, e);
        }
    }

    /**
     * spring容器启动时初始化guava cache
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        CACHE = CacheBuilder.newBuilder()
                //并发级别=8，并发级别表示可以同时写缓存的线程数
                .concurrencyLevel(8)
                //设置缓存容器的初始容量为50
                .initialCapacity(50)
                //设置缓存最大容量为100，超过100之后就会按照LRU最近最少使用移除缓存项
                .maximumSize(100)
                //设置写缓存后100毫秒后过期
                .expireAfterWrite(100, TimeUnit.MILLISECONDS)
                //统计缓存情况，生产环境慎重使用
                .recordStats()
                //build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
                .build(new BookEntityCacheLoader());
    }

    /**
     * 缓存不存在或者过期时触发load方法回源更新缓存
     */
    public class BookEntityCacheLoader extends CacheLoader<String, BookEntity> {
        @Override
        public BookEntity load(String key) {
            try {
                return bookService.findByBookName(key);
            } catch (Exception e) {
                LOGGER.error("cache load error. key:{}", key);
                return null;
            }
        }
    }
}

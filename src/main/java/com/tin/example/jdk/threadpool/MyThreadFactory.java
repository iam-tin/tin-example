package com.tin.example.jdk.threadpool;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * title: MyThreadFactory
 * <p>
 * description: 自定义线程池工厂
 *
 * @author tin on 2021/1/1 下午12:08
 */
public class MyThreadFactory implements ThreadFactory {
    private final String namePrefix;
    private static final AtomicInteger threadNumber = new AtomicInteger(1);

    MyThreadFactory(String groupName) {
        namePrefix = "【" + groupName +
                "】，线程编号：";
    }

    public Thread newThread(Runnable r) {
        String threadName = namePrefix + threadNumber.getAndIncrement();
        return new Thread(null, r, threadName, 0);
    }
}

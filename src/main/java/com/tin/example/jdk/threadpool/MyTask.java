package com.tin.example.jdk.threadpool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * title: MyTask
 * <p>
 * description:
 *
 * @author tin on 2021/1/1 下午3:25
 */
public class MyTask implements Runnable {
    private static final AtomicInteger COUNT = new AtomicInteger(1);

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(markTask() + "执行者===>" + Thread.currentThread().getName());
    }

    public String markTask() {
        return "任务【" + COUNT.getAndIncrement() + "】. ";
    }
}

package com.tin.example.jdk.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * title: MyRejectedExecutionHandler
 * <p>
 * description: 自定义拒绝策略
 *
 * @author tin on 2021/1/1 下午12:59
 */
public class MyRejectedExecutionHandler implements RejectedExecutionHandler {
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("任务拒绝. executor:" + executor.toString() + ",runnable:" + r.toString());
    }
}

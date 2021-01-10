package com.tin.example.jdk.threadpool;

import java.util.concurrent.*;

/**
 * title: ThreadPoolExecutorTest
 * <p>
 * description: 线程池测试类
 *
 * @author tin on 2021/1/1 下午12:07
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<Runnable>(2);
        ThreadFactory threadFactory = new MyThreadFactory("@tin的线程池");
        RejectedExecutionHandler rejectedExecutionHandler = new MyRejectedExecutionHandler();

        //① 定义一个线程池，maximumPoolSize=2，队列长度=2
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(1,
                2,
                2,
                TimeUnit.SECONDS,
                queue,
                threadFactory,
                rejectedExecutionHandler);

        //② 执行任务，会启动2个线程处理任务
        Runnable task = new MyTask();
        for (int i = 0; i < 4; i++) {
            executorService.execute(task);
        }

        //③ 经过以下sleep步骤活线程数变为1
        for (int i = 0; i < 4; i++) {
            Thread.sleep(1000);
            System.out.println("corePoolSize:" + executorService.getPoolSize());
        }

        //④ 重新执行任务，此时一个线程不够使用，会重新生成新线程处理任务
        for (int i = 0; i < 4; i++) {
            executorService.execute(task);
        }

        //⑤ 重新经过以下sleep步骤活线程数重新变为1
        for (int i = 0; i < 4; i++) {
            Thread.sleep(1000);
            System.out.println("重新执行任务后corePoolSize:" + executorService.getPoolSize());
        }
        latch.await();
    }
}

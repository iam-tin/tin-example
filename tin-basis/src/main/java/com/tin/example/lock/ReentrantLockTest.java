package com.tin.example.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * title: ReentrantLockTest
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2021/01/07 上午10:27
 */
public class ReentrantLockTest extends ReentrantLock {
    private long counter;

    private static List<Thread> threadList = new ArrayList<>();

    public static void main(String[] args) {
        ReentrantLockTest lockTest = new ReentrantLockTest();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                try {
                    lockTest.lock();
                    lockTest.writing();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lockTest.unlock();
                }
            }, "thread(" + i + ") @【看点代码再上班】");
            thread.start();
            threadList.add(thread);
        }
    }

    void writing() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("sleep error. " + e);
        }
        counter++;
        System.out.println("counter:" + counter);
        for (Thread thread : threadList) {
            System.out.println("" + thread.getName() + ", thread state:" + thread.getState());
        }
    }

}

package com.tin.example.falls.sharing;

import org.springframework.util.StopWatch;

/**
 * title: AutoIncrement
 * <p>
 * description: 多线程环境下，long变量自增
 *
 * @author tin @看点代码再上班 on 2021/2/17 下午1:28
 */
public class AutoIncrement {

    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch("@看点代码再上班");
        stopWatch.start();
        System.out.println("====== start to iterate ======");
        autoIncrement(new LongNumber());

        stopWatch.stop();
        System.out.println("cost " + stopWatch.getTotalTimeMillis() + "ms");
    }

    private static void autoIncrement(LongNumber longNumber) throws InterruptedException {
        //打印对象字节大小
//        System.out.println("longX1 = " + ClassLayout.parseInstance(longNumber).toPrintable());
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                longNumber.n1++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                longNumber.n2++;
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    static class LongNumber {
        //        @sun.misc.Contended
        volatile long n1;
        volatile long n2;
    }
}

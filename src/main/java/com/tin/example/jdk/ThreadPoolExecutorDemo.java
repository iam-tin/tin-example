package com.tin.example.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * description: ThreadPoolExecutorDemo
 * <p>
 * 测试位移运算，测试线程池位移运算
 * <p>
 *
 * @author tin on 2021/1/1 上午8:42
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        printBit();
    }

    private static void printBit() {
        System.out.println("res:" + Integer.toBinaryString(-(Integer.MAX_VALUE) - 1));
        System.out.println("res:" + Integer.SIZE);

        //移位运算
        int COUNT_BITS = Integer.SIZE - 3;
        int COUNT_MASK = (1 << COUNT_BITS);
        System.out.println("res:" + Integer.toBinaryString(COUNT_MASK));
    }
}

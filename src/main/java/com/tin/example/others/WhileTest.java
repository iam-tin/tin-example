package com.tin.example.others;

/**
 * title: WhileTest
 * <p>
 * description:
 *
 * @author tin on 2021/1/2 下午2:47
 */
public class WhileTest {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 1000000; i++) {
                System.out.println("i:" + i);
            }
        } catch (Exception e) {

        } finally {
            System.out.println("finally.");
        }
    }
}

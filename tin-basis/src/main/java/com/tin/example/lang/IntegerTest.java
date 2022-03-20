package com.tin.example.lang;

/**
 * title: IntegerTest
 * <p>
 * description: Integer包装类相关测试
 *
 * @author tin @看点代码再上班 on 2021/5/15 下午1:28
 */
public class IntegerTest {

    public static void main(String[] args) throws InterruptedException {
        Integer a = 127;
        Integer b = 127;
        System.out.println("res:" + (a == b));
        a = 128;
        b = 128;
        System.out.println("res:" + (a == b));
        a = -128;
        b = -128;
        System.out.println("res:" + (a == b));
        a = -129;
        b = -129;
        System.out.println("res:" + (a == b));

        b=500;
        int c = 500;
        System.out.println("res:" + (b == c));

    }
}

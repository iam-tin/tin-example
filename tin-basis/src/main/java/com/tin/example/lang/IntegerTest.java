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

        //Integer a = 1 等号左边是 Integer 类型，等号右边是 int 类型 ，这种写法叫做装箱
        //（基本类型与其对应的包装类型之间的赋值使用自动装箱与拆箱完成），而装箱操作是通过 Integer.valueOf(1) 完成的，所以：
        //Integer a = 1 等同于 Integer.valueOf(1)
        Integer a = 1;

        //new Integer(1) ：会新建一个对象；
        Integer b = new Integer(1);

        //Integer.valueOf(1) ：使用对象池中的对象，如果多次调用，会取得同一个对象的引用。
        Integer c = Integer.valueOf(1);
        System.out.println("res:" + (a == b));
        System.out.println("res:" + (a == c));
        System.out.println("res:" + (b == c));
    }
}

package com.tin.example.shutdown.hook;

/**
 * title: ShutdownHookTest
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2022/4/5 下午12:27
 */
public class JVMShutdownHookTest {
    public static void main(String[] args) throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread(JVMShutdownHookTest::doSomething));

        while (true) {
            System.out.println("i am running...");
            Thread.sleep(500);
        }
    }

    /**
     * 停机前处理事项
     */
    private static void doSomething() {
        System.out.println("关闭【看点代码再上班】书库。");
    }
}

package com.tin.example.spring.log4j2;


import org.junit.jupiter.api.Test;

import java.net.URL;

/**
 * title: SystemTest
 * <p>
 * description:  系统测试类
 *
 * @author tin @看点代码再上班 on 2021/1/16 上午10:24
 */
public class ClassLoaderTest {

    @Test
    public void test_getSystemResources() {
//        ClassLoader.getSystemResource()
    }


    @Test
    public void test_bootstrapClassLoader() {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }
    }

    @Test
    public void test_appClassLoader() {
        ClassLoader ClassLoader1 = ClassLoaderTest.class.getClassLoader();
        ClassLoader ClassLoader2 = ClassLoader1.getParent();
        ClassLoader ClassLoader3 = ClassLoader2.getParent();

        System.out.println(ClassLoader1);
        System.out.println(ClassLoader2);
        System.out.println(ClassLoader3);
    }
}

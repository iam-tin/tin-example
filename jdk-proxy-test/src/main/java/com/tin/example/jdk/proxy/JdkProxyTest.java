package com.tin.example.jdk.proxy;

/**
 * title: JdkProxyTest
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2022/1/22 上午9:11
 */
public class JdkProxyTest {
    public static void main(String[] args) throws Exception {
        //sun.misc.ProxyGenerator.saveGeneratedFiles 用于输出代理类class文件到本地
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        //代理接口实现类
        BookFacade proxy = (BookFacade) new MyInvocationHandler().getInstance(new BookFacadeImpl());
        proxy.addBook("Java性能权威指南@【看点代码再上班】");

        //代理普通类
//        BookOperation bookOperation = (BookOperation) new MyInvocationHandler().getInstance(new BookOperation());
//        bookOperation.addBook("Java性能权威指南@【看点代码再上班】");
    }
}

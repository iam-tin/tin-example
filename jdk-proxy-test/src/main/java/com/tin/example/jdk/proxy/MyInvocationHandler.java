package com.tin.example.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * title: MyInvocationHandler
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2022/1/22 上午9:01
 */
public class MyInvocationHandler implements InvocationHandler {
    //目标对象
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Class clazz = this.target.getClass();
        // Proxy.newProxyInstance的三个参数分别是：
        // 1 被代理类的类加载器
        // 2 被代理类的接口
        // 3 java.lang.reflect.InvocationHandler
        return Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("------前置通知------------");
        // 执行目标方法
        Object result = method.invoke(target, args);
        System.out.println("------后置处理------------");
        return result;
    }
}

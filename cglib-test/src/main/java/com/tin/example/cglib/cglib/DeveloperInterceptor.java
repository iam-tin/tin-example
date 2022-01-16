package com.tin.example.cglib.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * title: DeveloperInterceptor
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2022/1/15 下午4:57
 */
public class DeveloperInterceptor implements MethodInterceptor {
    /**
     * @param o           目标对象
     * @param method      目标方法
     * @param objects     为参数
     * @param methodProxy CGlib方法代理对象
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用前:" + method.getName());
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("调用后:" + method.getName());
        return result;
    }
}

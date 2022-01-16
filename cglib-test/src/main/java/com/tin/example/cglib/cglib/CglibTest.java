package com.tin.example.cglib.cglib;

import com.tin.example.cglib.design.pattern.SexEnum;
import com.tin.example.cglib.design.pattern.employee.Developer;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * title: CglibTest
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2022/1/15 下午5:00
 */
public class CglibTest {
    public static void main(String args[]) {
        //输出cglib动态代理产生的类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/ericli/small-workshop/workspace/tin-example/cglib-class");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Developer.class);
        //设置拦截器DeveloperInterceptor
        enhancer.setCallback(new DeveloperInterceptor());
        //enhancer.create()生成代理类并强转为Developer，cglig生成的代理类命名格式：业务类名$$EnhancerByCGLIB$$...
        Object obj = enhancer.create();
        System.out.println("proxy class:" + obj.getClass());
        Developer developer = (Developer) obj;
        developer.setLines(30000);
        developer.setName("程序员@【看点代码再上班】");
        developer.setNumber(1L);
        developer.setSex(SexEnum.MALE);
        developer.setSalary("￥15000");
        System.out.println(developer.print());
    }
}

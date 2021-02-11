package com.tin.example.jit;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * title: JITCompiler
 * <p>
 * description: 测试查看JIT编译结果，在JVM启动参数加如下：
 * -XX:+UnlockDiagnosticVMOptions
 * -XX:+PrintAssembly -Xcomp
 * -XX:CompileCommand=print,*AtomicInteger.incrementAndGet
 *
 * @author tin @看点代码再上班 on 2021/2/4 下午11:30
 */
public class JITCompiler {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.incrementAndGet();
    }
}

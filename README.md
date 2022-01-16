# tin-example
iam-tin@看点代码再上班 的源码分析&amp;测试用例。源码对应的分析文章都在公众号【看点代码再上班】，欢迎围观。

================================================

# 模块划分
## application-startup 
启动模块，除了spring容器启动，原则上不加其他逻辑代码

## spring-log4j2
测试lo4j2的模块，包括log脱敏功能

## tin-basis
其他的一些基础测试，一般包括jdk源码研读的测试用例
### lang
java.lang包测试

### false.sharing包
伪共享测试

### jdk包
#### threadpool 线程池测试

### jit包
即时编译测试

### lock包
Java锁

# spring-cache包
spring cache相关测试包

# cglib-test
测试cglib相关，包括访问者模式、asm、cglib增强实现

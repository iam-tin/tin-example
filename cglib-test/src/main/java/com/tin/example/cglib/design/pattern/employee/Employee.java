package com.tin.example.cglib.design.pattern.employee;

import com.tin.example.cglib.design.pattern.SexEnum;
import com.tin.example.cglib.design.pattern.visitor.Visitor;
import lombok.Data;

/**
 * title: Employee
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2022/1/15 上午10:24
 */
@Data
public abstract class Employee {
    /**
     * 工号
     */
    private long number;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private SexEnum sex;
    /**
     * 薪水
     */
    private String salary;

    public Employee() {
    }

    public Employee(Employee employee) {
        this.name = employee.getName();
        this.number = employee.getNumber();
        this.sex = employee.getSex();
        this.salary = employee.getSalary();
    }

    public String print() {
        return printSelf();
    }

    /**
     * 接受的访问者
     */
    public abstract void accept(Visitor visitor);

    /**
     * 私有方法
     *
     * @return
     */
    private String printSelf() {
        return "姓名：" + name + "，性别：" + sex + "，月薪：" + salary;
    }
}

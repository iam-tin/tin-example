package com.tin.example.cglib.design.pattern.visitor;

import com.tin.example.cglib.design.pattern.employee.Developer;
import com.tin.example.cglib.design.pattern.employee.ProductManager;

/**
 * title: HRVisitor
 * <p>
 * description:普通hr
 *
 * @author tin @公众号【看点代码再上班】 on 2022/1/15 上午11:09
 */
public class HRVisitor extends Visitor {
    @Override
    public void visit(ProductManager employee) {
        if (employee == null) {
            return;
        }
        ProductManager copy = new ProductManager(employee);
        copy.setSalary("￥*****");
        System.out.println(copy.print());
    }

    @Override
    public void visit(Developer employee) {
        if (employee == null) {
            return;
        }
        Developer copy = new Developer(employee);
        copy.setSalary("￥*****");
        System.out.println(copy.print());
    }
}

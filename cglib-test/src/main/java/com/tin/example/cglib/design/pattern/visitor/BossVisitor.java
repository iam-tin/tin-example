package com.tin.example.cglib.design.pattern.visitor;

import com.tin.example.cglib.design.pattern.employee.Developer;
import com.tin.example.cglib.design.pattern.employee.ProductManager;

/**
 * title: BossVisitor
 * <p>
 * description: 老板
 *
 * @author tin @公众号【看点代码再上班】 on 2022/1/15 上午11:06
 */
public class BossVisitor extends Visitor {
    @Override
    public void visit(ProductManager employee) {
        System.out.println(employee.print());
    }

    @Override
    public void visit(Developer employee) {
        System.out.println(employee.print());
    }
}

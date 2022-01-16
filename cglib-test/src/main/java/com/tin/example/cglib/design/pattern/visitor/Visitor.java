package com.tin.example.cglib.design.pattern.visitor;

import com.tin.example.cglib.design.pattern.employee.Developer;
import com.tin.example.cglib.design.pattern.employee.ProductManager;

/**
 * title: Visitor
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2022/1/15 上午10:45
 */
public abstract class Visitor {
    public abstract void visit(ProductManager employee);

    public abstract void visit(Developer employee);
}

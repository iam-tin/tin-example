package com.tin.example.cglib.design.pattern.employee;

import com.tin.example.cglib.design.pattern.visitor.Visitor;
import lombok.Data;

/**
 * title: ProductManager
 * <p>
 * description: 产品经理
 *
 * @author tin @公众号【看点代码再上班】 on 2022/1/15 上午10:43
 */
@Data
public class ProductManager extends Employee {
    /**
     * 需求文档
     */
    private String documentUrl;

    public ProductManager() {
    }

    public ProductManager(ProductManager productManager) {
        super(productManager);
        this.documentUrl = productManager.getDocumentUrl();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String print() {
        return super.print() + "，提需求：" + documentUrl;
    }
}

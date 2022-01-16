package com.tin.example.cglib.design.pattern.employee;

import com.tin.example.cglib.design.pattern.visitor.Visitor;
import lombok.Data;

/**
 * title: Developer
 * <p>
 * description: 开发
 *
 * @author tin @公众号【看点代码再上班】 on 2022/1/15 上午10:48
 */
@Data
public class Developer extends Employee {
    /**
     * 代码行数
     */
    private long lines;

    public Developer() {
    }

    public Developer(Developer developer) {
        super(developer);
        this.lines = developer.getLines();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String print() {
        return super.print() + "，代码行数：" + lines;
    }

    public long mock(long lines) {
        System.out.println("mock 代码行数:" + lines);
        return this.lines + lines;
    }

    public long mock2(long lines) {
        System.out.println("mock 代码行数2:" + lines);
        return this.lines + lines;
    }
}

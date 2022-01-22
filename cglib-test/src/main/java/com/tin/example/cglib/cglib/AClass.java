package com.tin.example.cglib.cglib;

/**
 * title: AClass
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2022/1/16 下午6:13
 */
public class AClass {
    public void print() {
        System.out.println("A");
    }
    public static void main(String[] args) {
        AClass a = new BClass();
        a.print();
        BClass b = new BClass();
        b.print();
        new BClass().print();
    }
}

class BClass extends AClass {
    public void print() {
        System.out.println("B");
    }

}

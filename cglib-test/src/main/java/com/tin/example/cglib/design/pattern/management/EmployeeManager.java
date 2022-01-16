package com.tin.example.cglib.design.pattern.management;

import com.tin.example.cglib.design.pattern.SexEnum;
import com.tin.example.cglib.design.pattern.employee.Developer;
import com.tin.example.cglib.design.pattern.employee.Employee;
import com.tin.example.cglib.design.pattern.employee.ProductManager;

import java.util.ArrayList;
import java.util.List;

/**
 * title: EmployeeManager
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2022/1/15 上午11:33
 */
public class EmployeeManager {
    private static List<Employee> LIST = new ArrayList<>();

    static {
        Developer developer = new Developer();
        developer.setLines(30000);
        developer.setName("程序员@【看点代码再上班】");
        developer.setNumber(1L);
        developer.setSex(SexEnum.MALE);
        developer.setSalary("￥15000");
        LIST.add(developer);
        ProductManager manager = new ProductManager();
        manager.setDocumentUrl("https://github.com/iam-tin/books");
        manager.setName("产品经理@【看点代码再上班】");
        manager.setNumber(2L);
        manager.setSex(SexEnum.FEMALE);
        manager.setSalary("￥13500");
        LIST.add(manager);
    }

    public static List<Employee> getAllEmployee() {
        return LIST;
    }
}

package com.tin.example.cglib.design.pattern;

import com.tin.example.cglib.design.pattern.employee.Developer;
import com.tin.example.cglib.design.pattern.employee.Employee;
import com.tin.example.cglib.design.pattern.employee.ProductManager;
import com.tin.example.cglib.design.pattern.management.EmployeeManager;
import com.tin.example.cglib.design.pattern.visitor.BossVisitor;
import com.tin.example.cglib.design.pattern.visitor.HRVisitor;

import java.util.List;

/**
 * title: MainClass
 * <p>
 * description:
 *
 * @author tin @公众号【看点代码再上班】 on 2022/1/15 上午11:43
 */
public class MainClass {

    public static void main(String[] args) {
        List<Employee> allEmployee = EmployeeManager.getAllEmployee();

        BossVisitor boss = new BossVisitor();
        HRVisitor hr = new HRVisitor();

        for (Employee employee : allEmployee) {
            if (employee instanceof Developer) {
                boss.visit((Developer) employee);
                hr.visit((Developer) employee);
            }
            if (employee instanceof ProductManager) {
                boss.visit((ProductManager) employee);
                hr.visit((ProductManager) employee);
            }

        }
    }
}

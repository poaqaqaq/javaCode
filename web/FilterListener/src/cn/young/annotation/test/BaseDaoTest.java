package cn.young.annotation.test;

import cn.young.annotation.dao.EmployeeDao;
import cn.young.annotation.dao.impl.EmployeeDaoImpl;
import org.junit.Test;

public class BaseDaoTest {
    @Test
    public void testFindById() {
        EmployeeDao employee = new EmployeeDaoImpl();
        System.out.println(employee.findById(3));
    }

    @Test
    public void testGetAll() {
        EmployeeDao employee = new EmployeeDaoImpl();
        System.out.println(employee.findAll());
    }
}

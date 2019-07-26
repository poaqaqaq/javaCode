package cn.young.test;

import cn.young.entity.Employee;
import cn.young.service.EmployeeService;
import cn.young.service.impl.EmployeeServiceImpl;
import cn.young.util.BaseDaoUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class TestBaseDao {
    private EmployeeService employeeService = null;

    @Before
    public void before() {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void updateTest() {
        Employee employee = new Employee();
        employee.setId(4);
        employee.setName("lila");
        employeeService.update(employee);
        System.out.println("done");
    }

    @Test
    public void deleteTest() {
        employeeService.delete(1);
        System.out.println("done");
    }

    @Test
    public void insertTest(){
        Employee employee = new Employee();
        employee.setName("west");
        employee.setAge(15);
        employee.setSex("man");
        employee.setDate(new Date());
        employeeService.insert(employee);
        System.out.println("done");
    }
}

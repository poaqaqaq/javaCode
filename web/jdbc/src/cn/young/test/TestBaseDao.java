package cn.young.test;

import cn.young.entity.Employee;
import cn.young.service.EmployeeService;
import cn.young.service.impl.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class TestBaseDao {
    private EmployeeService employeeService = null;

    @Before
    public void before() {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void updateTest() {
        Employee employee = new Employee();
        employee.setId(7);
        employee.setName("lila");
        employeeService.update(employee);
        System.out.println("done");
    }

    @Test
    public void deleteTest() {
        employeeService.delete(7);
        System.out.println("done");
    }

    @Test
    public void insertTest() {
        Employee employee = new Employee();
        employee.setName("west");
        employee.setAge(15);
        employee.setSex("man");
        employee.setDate(new Date());
        employeeService.insert(employee);
        System.out.println("done");
    }

    @Test
    public void selectAllTest() {
        List<Employee> all = employeeService.findAll();
        if (all != null) {
            for (Employee employee : all) {
                System.out.println(employee);
            }
        }
    }
}

package cn.young.test;

import cn.young.entity.Employee;
import cn.young.service.EmployeeService;
import cn.young.service.impl.EmployeeServiceImpl2;
import cn.young.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class DbUtilsTest {
    private EmployeeService employeeService = new EmployeeServiceImpl2();

    @Test
    public void testQueryRunnerInsert() {
        Employee employee = new Employee();
        employee.setName("east");
        employee.setAge(18);
        employee.setSex("woman");
        employee.setDate(new Date());
        employeeService.insert(employee);
        System.out.println("done");
    }

    @Test
    public void TestSelectOne() {
        Employee employee = employeeService.findById(6);
        System.out.println(employee);
    }

    @Test
    public void TestSelectMore() {
        List<Employee> employee = employeeService.findAll();
        for (Employee employee1 : employee) {
            System.out.println(employee1.toString());
        }
    }

    @Test
    public void testSelectScalar() {
        //多态时，父类调用子类特有的方法时，需要强转才能调用
        System.out.println(((EmployeeServiceImpl2) employeeService).getNameById(6));
    }

    @Test
    public void testSelectCount() {
        //多态时，父类调用子类特有的方法时，需要强转才能调用
        System.out.println(((EmployeeServiceImpl2) employeeService).getCount());
    }

    @Test
    public void testSelectSum() {
        System.out.println(((EmployeeServiceImpl2) employeeService).getSum());
    }

    @Test
    public void testIdList() {
        System.out.println(((EmployeeServiceImpl2) employeeService).getIdList());
    }

    @Test
    public void testBatchInsert() {
        Object[][] objects = new Object[10][];
        for (int i = 0; i < 10; i++) {
            //声明二维数组中的数组值
            objects[i] = new Object[]{"name", 11, "woman", new Date()};
        }
        //批量插入，使用二维Object数组，格式：new Object[][]{ {"name", 12, "woman", new Date()} }
        ((EmployeeServiceImpl2) employeeService).batchInsert(new Object[][]{{"name", 12, "woman", new Date()}});
        System.out.println("done");
    }
}

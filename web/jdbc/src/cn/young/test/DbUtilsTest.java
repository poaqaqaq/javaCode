package cn.young.test;

import cn.young.entity.Employee;
import cn.young.service.EmployeeService;
import cn.young.service.impl.EmployeeServiceImpl2;
import cn.young.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Test
    public void testMap() {
        String sql = "select * from employee where id = 6";
        Connection conn = JdbcUtil.getConnection();
        QueryRunner qr = new QueryRunner();
        try {
            //MapHandler只返回一条Map类型，key为字段名，value为字段值
            Map<String, Object> map = qr.query(conn, sql, new MapHandler());
            System.out.println(map.keySet());
            System.out.println(map);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn);
        }
    }

    @Test
    public void testMapList() {
        String sql = "select * from employee";
        Connection conn = JdbcUtil.getConnection();
        QueryRunner qr = new QueryRunner();
        try {
            //MapListHandler返回List类型，每一个list项中包含一个Map，key为字段名，value为字段值
            List<Map<String, Object>> query = qr.query(conn, sql, new MapListHandler());
            for (Map<String, Object> stringObjectMap : query) {
//                System.out.println(stringObjectMap.keySet());//输出：[id, name, age, sex, date]
//                Set<Map.Entry<String, Object>> entries = stringObjectMap.entrySet();
                for (Map.Entry<String, Object> entry : stringObjectMap.entrySet()) {
                    System.out.println(entry.getKey() + "：" + entry.getValue());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn);
        }

    }

    //    4.keyedHandler:取多条记录，每一条记录封装到一个map中，再将这个map封装到另一个map中，key为指定的字段值。
    @Test
    public void testKeyedHandler() throws SQLException {
        Connection conn = JdbcUtil.getConnection();
        QueryRunner qr = new QueryRunner();
        //以第一列id的值为大map的key值,里面的map，就是筛选出的字段，例如这里里面的map，就是<id,value>和<name,value>
        Map<Integer, Map<String, Object>> map = qr.query(conn, "select id,name from employee limit 5", new KeyedHandler<>("id"));
        for (Map.Entry<Integer, Map<String, Object>> bm : map.entrySet()) {
            System.out.println("最外层key值："+bm.getKey());
            for (Map.Entry<String, Object> mm : bm.getValue().entrySet()) {
                System.out.println(mm.getKey() + "        " + mm.getValue());
            }
            System.out.println("---------------------------");
        }
    }
}

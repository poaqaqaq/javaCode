package cn.young.test;

import cn.young.entity.Basic;
import cn.young.entity.Employee;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.HashMap;

public class BeanUtilTest {
    @Test
    //通过BeanUtils设置对应Bean的属性，需要引入beanUtils包和logging包
    public void test1() {
        Basic basicOrigin = new Basic();
        try {
            //copyProperty依赖于对应Bean的setter和getter方法，如果对应Bean没有setter和getter方法将不会设置成功
            BeanUtils.copyProperty(basicOrigin, "cn_content", "中文内容");
            BeanUtils.copyProperty(basicOrigin, "en_content", "faasf");
            //如果有不存在的属性，将会自动过滤
            BeanUtils.copyProperty(basicOrigin, "e222n_content", "faasf");
            //如果是基本数据类型则会自动转换，前提是要能转换成功，这里如果是3444a，则转换成int会失败，不会设置属性
            BeanUtils.copyProperty(basicOrigin, "id", "364324");
            System.out.println(basicOrigin);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    //拷贝对象，从源对象拷贝到目标对象
    public void test2() {
        Basic basicOrigin = new Basic();
        basicOrigin.setId(1);
        basicOrigin.setCreated_at(new Timestamp(System.currentTimeMillis()));
//        basicOrigin.setUpdated_at(new Timestamp(System.currentTimeMillis()));//此处不设置值将会抛出异常
        basicOrigin.setCn_content("cn_content");
        Basic basicDest = new Basic();
        try {
            //当用到了时间等非内置对象时，如果属性为NULL则，会出现此异常:No value specified for 'java.sql.Timestamp。
            //最简单的方法就是保证非内置对象不为NULL,即特殊属性都设置值
            BeanUtils.copyProperties(basicDest, basicOrigin);
            System.out.println(basicOrigin);
            System.out.println(basicDest);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        Employee employeeOrigin = new Employee();
        employeeOrigin.setName("name");
        employeeOrigin.setAge(111);
        employeeOrigin.setSex("gender");
        try {
            Employee employeeDest = new Employee("mike");
            //复制对象，目标，源，目标对象的属性值将会被覆盖
            BeanUtils.copyProperties(employeeDest, employeeOrigin);
            System.out.println(employeeOrigin);
            System.out.println(employeeDest);
            System.out.println(employeeOrigin == employeeDest);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "名称");
        map.put("age", "16");
        map.put("sex", "man");
        Employee employee = new Employee("george");
        try {
            //通过一个Map，key为属性名，value为属性值，来给Bean赋值
            BeanUtils.populate(employee, map);
            System.out.println(employee);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

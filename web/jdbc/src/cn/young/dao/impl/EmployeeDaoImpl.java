package cn.young.dao.impl;

import cn.young.dao.EmployeeDao;
import cn.young.entity.Employee;
import cn.young.util.BaseDaoUtil;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private String tableName = " employee ";

    @Override
    public void delete(int id) {
        String sql = "delete from" + tableName + "where id = ?";
        BaseDaoUtil.update(sql, id);
    }

    @Override
    public void update(Employee employee) {
        String sql = "update" + tableName + "set name=? where id = ?";
        BaseDaoUtil.update(sql, employee.getName(), employee.getId());
    }

    @Override
    public void insert(Employee employee) {
        String sql = "insert into " + tableName + " values(null,?,?,?,?)";
        BaseDaoUtil.update(sql, employee.getName(), employee.getAge(), employee.getSex(), employee.getDate());
    }

    @Override
    public List<Employee> findAll() {
        return BaseDaoUtil.query("select * from" + tableName, Employee.class);
    }

    @Override
    public Employee findById(int id) {
        List<Employee> list = BaseDaoUtil.query("select * from" + tableName + " where id = ?", Employee.class, id);
        return list.get(0);
    }
}

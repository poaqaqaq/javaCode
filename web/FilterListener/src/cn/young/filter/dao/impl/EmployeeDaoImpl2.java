package cn.young.filter.dao.impl;

import cn.young.filter.dao.EmployeeDao;
import cn.young.filter.entity.Employee;
import cn.young.filter.util.QueryRunnerDaoUtil;

import java.math.BigDecimal;
import java.util.List;

public class EmployeeDaoImpl2 implements EmployeeDao {
    private String tableName = " employee ";
    //使用DbUtils组件

    @Override
    public void delete(int id) {
        String sql = "delete from" + tableName + "where id = ?";
        QueryRunnerDaoUtil.update(sql, id);
    }

    @Override
    public void update(Employee employee) {
        String sql = "update" + tableName + "set name=? where id = ?";
        QueryRunnerDaoUtil.update(sql, employee.getName(), employee.getId());
    }

    @Override
    public void insert(Employee employee) {
        String sql = "insert into " + tableName + " values(null,?,?,?,?)";
        QueryRunnerDaoUtil.update(sql, employee.getName(), employee.getAge(), employee.getSex(), employee.getDate());
    }

    @Override
    public List<Employee> findAll() {
        return QueryRunnerDaoUtil.query4List("select * from" + tableName, Employee.class);
    }

    @Override
    public Employee findById(int id) {
        return QueryRunnerDaoUtil.query4OneObject("select * from" + tableName + " where id = ? limit 1", Employee.class, id);
    }

    @Override
    public Employee getInfoByNameAndPassword(Employee employee) {
        return QueryRunnerDaoUtil.query4OneObject("select * from" + tableName + " where name = ? and password = ? limit 1", Employee.class, employee.getName(), employee.getPassword());

    }
}

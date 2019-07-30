package cn.young.dao.impl;

import cn.young.dao.EmployeeDao;
import cn.young.entity.Employee;
import cn.young.util.BaseDaoUtil;
import cn.young.util.QueryRunnerDaoUtil;

import java.math.BigDecimal;
import java.util.List;

public class EmployeeDaoImpl2 implements EmployeeDao {
    private String tableName = " employee ";
    //使用DbUtils组件

    @Override
    public void delete(int id) {
        String sql = "delete from" + tableName + "where id = ?";
        BaseDaoUtil.update(sql, id);
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
        return QueryRunnerDaoUtil.query4OneObject("select * from" + tableName + " where id = ?", Employee.class, id);
    }

    public String getNameById(int id) {
        String string = QueryRunnerDaoUtil.query4Scalar("select name from" + tableName + " where id = ?", String.class, id);
        return string;
    }

    //count返回的是Long类型！
    public long getCount() {
        return QueryRunnerDaoUtil.query4Scalar("select count(*) from" + tableName);
    }

    //sum返回的是BigDecimal类型！
    public BigDecimal getSum() {
        BigDecimal big = QueryRunnerDaoUtil.query4Scalar("select sum(id) from" + tableName);
        return big;
    }

    public List<Integer> getIdList() {
        List<Integer> objects = QueryRunnerDaoUtil.query4Column("select id from" + tableName);
        return objects;
    }

    public void batchInsert(Object[][] params) {
        QueryRunnerDaoUtil.batchUpdate("insert into " + tableName + " values(null,?,?,?,?)", params);
    }
}

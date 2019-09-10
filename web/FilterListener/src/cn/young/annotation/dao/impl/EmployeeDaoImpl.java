package cn.young.annotation.dao.impl;

import cn.young.annotation.dao.BaseDao;
import cn.young.annotation.dao.EmployeeDao;
import cn.young.annotation.entity.Employee;

import java.util.List;

public class EmployeeDaoImpl extends BaseDao<Employee> implements EmployeeDao {
    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void insert(Employee employee) {

    }

    @Override
    public List<Employee> findAll() {
        return getList();
    }

    @Override
    public Employee findById(int id) {
       return super.findById(id);
    }

    @Override
    public Employee getInfoByNameAndPassword(Employee employee) {
        return null;
    }
}

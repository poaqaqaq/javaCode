package cn.young.service.impl;

import cn.young.dao.EmployeeDao;
import cn.young.dao.impl.EmployeeDaoImpl;
import cn.young.dao.impl.EmployeeDaoImpl2;
import cn.young.entity.Employee;
import cn.young.service.EmployeeService;
import cn.young.util.QueryRunnerDaoUtil;

import java.math.BigDecimal;
import java.util.List;

public class EmployeeServiceImpl2 implements EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDaoImpl2();

    @Override
    public void delete(int id) {
        employeeDao.delete(id);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void insert(Employee employee) {
        employeeDao.insert(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    public String getNameById(int id) {
        return ((EmployeeDaoImpl2) employeeDao).getNameById(id);
    }

    public long getCount() {
        return ((EmployeeDaoImpl2) employeeDao).getCount();
    }

    public BigDecimal getSum() {
        return ((EmployeeDaoImpl2) employeeDao).getSum();
    }

    public List<Integer> getIdList() {
        return ((EmployeeDaoImpl2) employeeDao).getIdList();
    }

    public void batchInsert(Object[][] params) {
        ((EmployeeDaoImpl2) employeeDao).batchInsert(params);
    }
}

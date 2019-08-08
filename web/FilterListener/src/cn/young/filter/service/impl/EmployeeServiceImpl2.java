package cn.young.filter.service.impl;

import cn.young.filter.dao.EmployeeDao;
import cn.young.filter.dao.impl.EmployeeDaoImpl2;
import cn.young.filter.entity.Employee;
import cn.young.filter.exception.LoginFailedException;
import cn.young.filter.service.EmployeeService;

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

    @Override
    public Employee getInfoByNameAndPassword(Employee employee) throws LoginFailedException {
        Employee result = employeeDao.getInfoByNameAndPassword(employee);
        if (result == null) {
            throw new LoginFailedException();
        }
        return result;
    }
}

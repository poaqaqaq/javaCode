package cn.young.service.impl;

import cn.young.dao.EmployeeDao;
import cn.young.dao.impl.EmployeeDaoImpl;
import cn.young.entity.Employee;
import cn.young.service.EmployeeService;
import cn.young.util.BaseDaoUtil;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

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
        return null;
    }
}

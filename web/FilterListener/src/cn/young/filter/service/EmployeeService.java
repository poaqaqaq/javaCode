package cn.young.filter.service;

import cn.young.filter.entity.Employee;
import cn.young.filter.exception.LoginFailedException;

import java.util.List;

public interface EmployeeService {
    void delete(int id);

    void update(Employee employee);

    void insert(Employee employee);

    List<Employee> findAll();

    Employee findById(int id);

    Employee getInfoByNameAndPassword(Employee employee) throws LoginFailedException;
}

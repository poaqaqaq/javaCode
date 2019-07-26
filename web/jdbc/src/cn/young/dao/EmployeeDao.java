package cn.young.dao;

import cn.young.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    void delete(int id);
    void update(Employee employee);
    void insert(Employee employee);
    List<Employee> findAll();
    Employee findById(int id);
}

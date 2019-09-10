package cn.young.annotation.dao;

import cn.young.annotation.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    void delete(int id);

    void update(Employee employee);

    void insert(Employee employee);

    List<Employee> findAll();

    Employee findById(int id);

    Employee getInfoByNameAndPassword(Employee employee);
}

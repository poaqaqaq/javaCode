package cn.DataSoucePage.dao;

import cn.DataSoucePage.entity.Page;
import cn.young.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getListByPage(Page page);
    long getTotalCount();
}

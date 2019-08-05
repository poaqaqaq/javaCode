package cn.DataSoucePage.service;

import cn.DataSoucePage.entity.Page;
import cn.young.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getListByPage(Page page);
}

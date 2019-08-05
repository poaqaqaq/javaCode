package cn.DataSoucePage.service.impl;

import cn.DataSoucePage.dao.EmployeeDao;
import cn.DataSoucePage.dao.impl.EmployeeDaoImpl;
import cn.DataSoucePage.entity.Page;
import cn.DataSoucePage.service.EmployeeService;
import cn.young.entity.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public List<Employee> getListByPage(Page page) {
        long totalCount = employeeDao.getTotalCount();
        page.setTotalPage((int) Math.ceil(totalCount / (double) page.getPageSize()));
        page.setTotalRow(totalCount);
        return employeeDao.getListByPage(page);
    }
}

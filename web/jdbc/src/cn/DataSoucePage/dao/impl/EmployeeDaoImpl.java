package cn.DataSoucePage.dao.impl;

import cn.DataSoucePage.dao.EmployeeDao;
import cn.DataSoucePage.entity.Page;
import cn.DataSoucePage.util.QueryRunnerDaoUtil;
import cn.young.entity.Employee;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private QueryRunnerDaoUtil dao = new QueryRunnerDaoUtil();

    @Override
    public List<Employee> getListByPage(Page page) {
        int offset = page.getOffset();
        int size = page.getPageSize();
        return QueryRunnerDaoUtil.query4List("select * from employee limit ?,?", Employee.class, offset, size);
    }

    @Override
    public long getTotalCount() {
        return QueryRunnerDaoUtil.query4Scalar("select count(*) from employee");
    }
}

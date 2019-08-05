package cn.DataSoucePage.servlet;

import cn.DataSoucePage.entity.Page;
import cn.DataSoucePage.service.EmployeeService;
import cn.DataSoucePage.service.impl.EmployeeServiceImpl;
import cn.young.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PageServlet", urlPatterns = "/page")
public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = Integer.parseInt(request.getParameter("p"));
        EmployeeService employeeService = new EmployeeServiceImpl();
        Page pageBean = new Page();
        if (page >= 1) {
            pageBean.setCurrent(page);
        }
        List<Employee> listByPage = employeeService.getListByPage(pageBean);
        request.setAttribute("page", pageBean);
        request.setAttribute("list", listByPage);
        //放到WEB-INFO下的jsp将不能被直接访问，只能通过转发访问
        request.getRequestDispatcher("/WEB-INF/page.jsp").forward(request, response);
    }
}

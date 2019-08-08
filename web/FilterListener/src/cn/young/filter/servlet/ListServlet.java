package cn.young.filter.servlet;

import cn.young.filter.entity.Employee;
import cn.young.filter.exception.LoginFailedException;
import cn.young.filter.service.EmployeeService;
import cn.young.filter.service.impl.EmployeeServiceImpl2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListServlet", urlPatterns = "/list")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeService employeeService = new EmployeeServiceImpl2();
        request.setAttribute("list", employeeService.findAll());
        request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
    }
}

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

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Employee employee = new Employee();
        employee.setName(name);
        employee.setPassword(password);
        EmployeeService employeeService = new EmployeeServiceImpl2();
        try {
            request.getSession().setAttribute("info", employeeService.getInfoByNameAndPassword(employee));
            response.sendRedirect(request.getContextPath() + "/list");
            response.getWriter().write("in22");
        } catch (LoginFailedException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}

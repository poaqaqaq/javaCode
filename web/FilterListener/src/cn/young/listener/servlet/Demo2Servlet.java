package cn.young.listener.servlet;

import cn.young.listener.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Demo2Servlet", urlPatterns = "/listener/demo2")
public class Demo2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = new Employee("george");
        request.getSession().setAttribute("employee",employee);
        try {
            Thread.sleep(3000);
            request.getSession().removeAttribute("employee");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

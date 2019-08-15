package cn.young.listener.servlet;

import cn.young.filter.entity.Employee;
import cn.young.filter.exception.LoginFailedException;
import cn.young.filter.service.EmployeeService;
import cn.young.filter.service.impl.EmployeeServiceImpl2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//当有同名Servlet时，name需要写上包名，或者直接不写name，@WebServlet注解会自动获取当前包与类名
@WebServlet(name = "cn.young.listener.servlet.LoginServlet", urlPatterns = "/aa")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("post");
//        String name = request.getParameter("name");
//        String password = request.getParameter("password");
//        Employee employee = new Employee();
//        employee.setName(name);
//        employee.setPassword(password);
//        EmployeeService employeeService = new EmployeeServiceImpl2();
//        try {
//            Employee infoByNameAndPassword = employeeService.getInfoByNameAndPassword(employee);
//            request.getSession().setAttribute("info", infoByNameAndPassword);
//            response.sendRedirect(request.getContextPath() + "/list");
//        } catch (LoginFailedException e) {
//            request.setAttribute("error", e.getMessage());
//            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in");
//        HttpSession session = request.getSession(false);
//        //返回null
//        System.out.println("beforeForward:"+session);
//        //转发时，Tomcat将会自动设置一个org.apache.catalina.session.StandardSessionFacade@xx的session
//        //所以判断用户是否登录必须要判断session里的userInfo！
//        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
//        //转发后有值
//        System.out.println("afterForward:"+request.getSession(false));
    }
}

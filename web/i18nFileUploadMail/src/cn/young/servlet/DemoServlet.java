package cn.young.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

//静态文本国际化
@WebServlet(name = "DemoServlet", urlPatterns = "/demo1")
public class DemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //读取浏览器的默认语言
        Locale locale = request.getLocale();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("cn.young.msg", locale);
        System.out.println(resourceBundle.getString("userName"));
        response.getWriter().write(resourceBundle.getString("userName"));
    }
}

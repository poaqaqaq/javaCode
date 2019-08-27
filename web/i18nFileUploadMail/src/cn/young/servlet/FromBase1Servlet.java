package cn.young.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "FromBase1Servlet",urlPatterns = "/base1")
public class FromBase1Servlet extends BaseServlet {
    public Object base(HttpServletRequest request, HttpServletResponse response) {
        return "http://baidu.com";
    }
}

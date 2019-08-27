package cn.young.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "FromBase2Servlet", urlPatterns = "/base2")
public class FromBase2Servlet extends BaseServlet {
    public Object base(HttpServletRequest request, HttpServletResponse response) {
        return request.getRequestDispatcher("/list");
    }
}

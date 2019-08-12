package cn.young.listener.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Demo1Servlet", urlPatterns = "/listener/demo1")
public class Demo1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("name", "george");
        response.getWriter().write("hello");

        try {
            Thread.sleep(3000);
            session.setAttribute("name", "mike");
            Thread.sleep(3000);
            session.removeAttribute("name");
            System.out.println("done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

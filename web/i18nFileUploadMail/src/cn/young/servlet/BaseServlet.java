package cn.young.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if (name != null && !"".equals(name.trim())) {
            Class<? extends BaseServlet> clazz = this.getClass();
            //Class clazz = this.getClass();//这样写的话，下面的clazz.getDeclaredMethod，将会提示未检查的类型警告
            try {
                System.out.println(HttpServletRequest.class == request.getClass());//false
                System.out.println(HttpServletRequest.class);//interface javax.servlet.http.HttpServletRequest
                System.out.println(request.getClass());//class org.apache.catalina.connector.RequestFacade

                //这里不能使用request.getClass()，因为这样会找不到对应方法！getClass()返回的是Tomcat创建的对象类型！
                Method declaredMethod = clazz.getDeclaredMethod(name, HttpServletRequest.class, HttpServletResponse.class);
                declaredMethod.setAccessible(true);
                Object uri = declaredMethod.invoke(this, request, response);
                jump(uri, request, response);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            response.getWriter().println("Cannot find");
        }
    }

    private void jump(Object uri, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (uri instanceof RequestDispatcher) {
                ((RequestDispatcher) uri).forward(request, response);
            } else {
                response.sendRedirect((String) uri);
            }
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}

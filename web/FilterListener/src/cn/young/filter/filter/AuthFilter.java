package cn.young.filter.filter;

import cn.young.filter.entity.Employee;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) resp;
//        String uri = request.getRequestURI();
//        //如果不是login和静态文件，则需要校验session
//        if (!(boolean) request.getAttribute("isStatic") && !uri.contains("login")) {
//            HttpSession session = request.getSession(false);
//            if (session == null || session.getAttribute("userInfo") == null) {
////                response.sendRedirect(request.getContextPath() + "/login");
//                //不加绝对路径，让浏览器自动判断当前路径
//                response.sendRedirect( "login");
////                response.sendRedirect("login");
//                System.out.println("no:" + uri);
//                return;
//            }
//        }
//        System.out.println("ok:" + uri);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

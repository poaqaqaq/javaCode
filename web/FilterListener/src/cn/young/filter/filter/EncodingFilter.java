package cn.young.filter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*", initParams = {@WebInitParam(name = "charset", value = "utf-8")})
public class EncodingFilter implements Filter {
    private String encoding;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        //设置请求编码
        req.setCharacterEncoding("UTF-8");
//        String uri = request.getRequestURI();
//        //当不是css和js的时候设置编码与contentType
//        if (!uri.endsWith(".css") && !uri.endsWith(".js")) {
//            //设置响应编码，一定要在响应之前设置
//            resp.setContentType("text/html;charset=" + encoding);
//        }
        if (!(boolean) request.getAttribute("isStatic")) {
            resp.setContentType("text/html;charset=" + encoding);
        }
        chain.doFilter(req, resp);
        System.out.println("encoding finished");
    }

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("charset");
    }

}

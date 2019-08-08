package cn.young.filter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.Enumeration;

//创建时机：过滤器在Web服务器启动的时候就加载了，因为要拦截Web资源，所以必须在所有Web资源启动之前就加载过滤器。
// filterName为过滤器名，urlPatterns为要过滤的映射路径： /* 匹配所有的地址，*.后缀名，如：*.action；
//  /index.jsp 精确过滤， *.jpg  过滤所有的图片， /manager/*  过滤URL路径包含此manager下所有的资源，
 // /aa/*/bb，这里的*不是通配的含义，精确匹配
/*
1.url-pattern要么以斜杠开头，要么以*.扩展名结尾  例如： /* 或*.do
2.不能同时出现这两种方式。例如 /*.do 是非法的，即路径和扩展名匹配无法同时设置
3.匹配一个urlPatterns = "/demo1"，可以同时匹配多个urlPatterns = {"/demo1","/demo2"}
注意，即使没有匹配的路径，filter还是会执行！例如这里Servlet没有demo2，则只会执行2和4的步骤
*/
//过滤器配置，可以写在web.xml或者直接配置@WebFilter中；
@WebFilter(filterName = "TestFilter", urlPatterns = {"/demo1", "/demo2"}, initParams = {
        @WebInitParam(name = "name", value = "george"),
        @WebInitParam(name = "age", value = "18"),
        @WebInitParam(name = "sex", value = "man")
})
public class TestFilter implements Filter {
    public TestFilter() {
        System.out.println("0.constructor");
    }

    //初始化方法， 在创建完过滤器对象之后被调用。只执行一次；
    public void init(FilterConfig config) throws ServletException {
        //获取初始化参数
        String name = config.getInitParameter("name");
        System.out.println(name);
        Enumeration<String> em = config.getInitParameterNames();
        while (em.hasMoreElements()) {
            String element = em.nextElement();
            System.out.println(config.getInitParameter(element));
        }
        System.out.println("1.init");
    }

    //执行过滤任务方法。执行多次。每次访问都会执行
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //每次访问的request过滤
        System.out.println("2.request filter");
        //放行请求到下个过滤器，如果没有下个过滤器，则直接访问对应的service方法,如果不调用此方法，则请求会被直接过滤
        chain.doFilter(req, resp);
        //业务处理后，即service方法执行完后执行response过滤
        System.out.println("4.response filter");
    }

    //Web服务器停止或者Web应用重新加载，销毁过滤器对象。
    public void destroy() {
        System.out.println("5.destroy");
    }
}

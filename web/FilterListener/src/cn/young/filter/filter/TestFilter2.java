package cn.young.filter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*
 * 如果使用web.xml，那么配置在前面的filter将会先执行，然后再执行后面的filter
 * 如果用@WebFilter注解，那么则是根据文件名从A-Z大到小的顺序而来
 *
 * Filter执行顺序确定后，将会按照filter顺序先后执行request的filter，接着再执行service业务方法，
 * 执行完service业务方法后，会按照配置的filter顺序反着执行response的filter，就好像进门先进1 2门，出门先出2 1门
 *
 * 默认过滤所有方式的请求
 * dispatcherTypes = DispatcherType.FORWARD 仅拦截转发类型
 *                                  REQUEST 仅拦截request,重定向也会被拦截
 *                                  ERROR   当触发了一次error的时候，就会走一次,例如404，500等
 *                                  INCLUDE 仅拦截include，即JSP中的include文件
 *            有时候不生效可能是URLPatterns没有匹配上对应的路由
 * */
//此处的意思是拦截转发到/demo2的路由:@WebFilter(filterName = "TestFilter2", urlPatterns = "/demo2", dispatcherTypes = DispatcherType.FORWARD)

@WebFilter(filterName = "TestFilter2", urlPatterns = {"/demo1", "/demo2"}, dispatcherTypes = {DispatcherType.INCLUDE, DispatcherType.ERROR})
public class TestFilter2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("testFilter2 request");
        chain.doFilter(req, resp);
        System.out.println("testFilter2 response");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

package cn.young.listener.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

/*
    创建监听器步骤：
    1.创建对应监听器（session，request，ServletContext）
    2.绑定到web.xml
    当有多个执行器时，context>request>session
    当有多个request执行器时，执行顺序与filter一致，即按文件排序执行，销毁则是相反！
 * 监听request创建与销毁
 * */
//这里可以直接使用注解，其实不写这段注解也会自动绑定到监听器
@WebListener()
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //从request事件获取request对象从而获取属性
        sre.getServletRequest().getAttribute("name");
        System.out.println("request init111111111");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request destroy11111111111");
    }
}

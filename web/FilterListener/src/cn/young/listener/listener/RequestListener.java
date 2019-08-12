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
 * 监听request创建与销毁
 * */

@WebListener()
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //从request事件获取request对象从而获取属性
        sre.getServletRequest().getAttribute("name");
        System.out.println("request init");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request destroy");
    }
}

package cn.young.listener.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

/*
    一共有3种属性变化监听器
*   ServletRequestAttributeListener
    HttpSessionAttributeListener
    ServletContextAttributeListener
* */

@WebListener()
public class SessionAttrListener implements HttpSessionAttributeListener {

    //当新增session属性时调用
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.println("Session attribute added");
    }

    //当替换session属性时调用，即当同名属性被设置时调用
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        System.out.println("Session attribute replaced");
    }

    //当session属性被移除时调用
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        System.out.println("Session attribute removed");
    }
}

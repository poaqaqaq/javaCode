package cn.young.listener.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

/*
* 监听ServletContext创建与销毁
* */

@WebListener()
public class ApplicationListener implements ServletContextListener {

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    //只会执行一次，在部署至服务器时调用
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context deployed");
    }

    //只会执行一次，当被“取消部署”时调用
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context unDeploy");
    }
}

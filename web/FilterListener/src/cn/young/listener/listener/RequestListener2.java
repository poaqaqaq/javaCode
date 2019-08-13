package cn.young.listener.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/*
    创建监听器步骤：
    1.创建对应监听器（session，request，ServletContext）
    2.绑定到web.xml
 * 监听request创建与销毁
 * */
//这里可以直接使用注解，其实不写这段注解也会自动绑定到监听器
@WebListener()
public class RequestListener2 implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //从request事件获取request对象从而获取属性
        sre.getServletRequest().getAttribute("name");
        System.out.println("request init22222222222");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request destroy222222222222");
    }
}

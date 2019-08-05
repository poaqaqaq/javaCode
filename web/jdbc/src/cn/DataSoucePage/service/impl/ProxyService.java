package cn.DataSoucePage.service.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyService implements InvocationHandler {
    private Object t;

    public ProxyService(Object t) {
        this.t = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long l = System.currentTimeMillis();
        Object invoke = method.invoke(t, args);
        System.out.println(method.getName() + ":" + String.valueOf(System.currentTimeMillis() - l) + "ms");
        return invoke;
    }
}

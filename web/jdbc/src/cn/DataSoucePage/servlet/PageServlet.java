package cn.DataSoucePage.servlet;

import cn.DataSoucePage.entity.Page;
import cn.DataSoucePage.service.EmployeeService;
import cn.DataSoucePage.service.impl.EmployeeServiceImpl;
import cn.DataSoucePage.service.impl.ProxyService;
import cn.young.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

@WebServlet(name = "PageServlet", urlPatterns = "/page")
public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //第二个参数必须为接口数组，如果抛出异常... is not an interface，证明第二个参数里不是接口；例：如果是一个类，则传new Class[]{xxx.class}类名，
        //如果已经是一个接口，则直接使用xxx.getClass().getInterfaces()即可！
        HttpServletRequest requestProxy = (HttpServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            //当代理对象的原本方法被调用的时候，会绑定执行一个方法，这个方法就是InvocationHandler里面定义的内容，同时会替代原本方法的结果返回。
            //proxy为代理后的对象,method为调用的方法，args为调用方法的参数
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("getParameter".equals(method.getName())) {
                    System.out.println("getParameter was invoked");
                }
                //返回执行结果
                return method.invoke(request, args);
                //因为proxy是代理类的对象，当该对象方法被调用的时候，会触发InvocationHandler，
                // 而InvocationHandler里面又调用一次proxy里面的对象，所以会不停地循环调用。并且，proxy对应的方法是没有实现的，所以这里是死循环
                //return method.invoke(proxy,args);
            }
        });
        requestProxy.setCharacterEncoding("UTF-8");
        int page = Integer.parseInt(requestProxy.getParameter("p"));
//        EmployeeService employeeService = new EmployeeServiceImpl();
        //如果想new ProxyService<>，这里面的<>不写具体类型，就必须在构造方法的时候就使用T，这样在构造方法的时候就可以确定T的类型，从而不需要再次在<>声明，否则必须要在<>声明！
        EmployeeService employeeService = (EmployeeService) Proxy.newProxyInstance(EmployeeService.class.getClassLoader(),
                new Class[]{EmployeeService.class},new ProxyService(new EmployeeServiceImpl()));

        Page pageBean = new Page();
        if (page >= 1) {
            pageBean.setCurrent(page);
        }
        List<Employee> listByPage = employeeService.getListByPage(pageBean);
        requestProxy.setAttribute("page", pageBean);
        requestProxy.setAttribute("list", listByPage);
        //放到WEB-INFO下的jsp将不能被直接访问，只能通过转发访问
        requestProxy.getRequestDispatcher("/WEB-INF/page.jsp").forward(requestProxy, response);
    }
}

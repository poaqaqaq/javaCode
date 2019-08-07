package cn.young.sevlet;

import cn.young.entity.Employee;
import cn.young.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "WebUtilServlet", urlPatterns = "/WebUtil")
public class WebUtilServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //src下所有的文件将会被编译至classes下
        //输出 E:\javaCode\javaCode\web\jdbc\out\artifacts\web_war_exploded\  ，即只会导航到编译后的目录
        System.out.println(getServletContext().getRealPath("/"));
        //输出 file:/E:/javaCode/javaCode/web/jdbc/out/artifacts/web_war_exploded/WEB-INF/classes/  ，是一个URL对象，导航到编译后的classes文件夹下！
        System.out.println(this.getClass().getResource("/"));//获取字节码所在的根路径

        //一个个封装bean属性
//        EmployeeDao employee = WebUtil.copyToBeanOld(request, EmployeeDao.class);
//        System.out.println(employee);

//        Map<String, String[]> map = request.getParameterMap();
//        Set<Map.Entry<String, String[]>> entries = map.entrySet();
//        for (Map.Entry<String, String[]> entry : entries) {
//            System.out.println(entry.getKey() + ":" + Arrays.toString(entry.getValue()));
//        }
//        //直接用map与populate结合封装bean属性
//        System.out.println(WebUtil.copyToBeanNew(request, Employee.class));
//        response.getWriter().write("done");
    }
}

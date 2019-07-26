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
        //一个个封装bean属性
//        EmployeeDao employee = WebUtil.copyToBeanOld(request, EmployeeDao.class);
//        System.out.println(employee);

        Map<String, String[]> map = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = map.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            System.out.println(entry.getKey() + ":" + Arrays.toString(entry.getValue()));
        }
        //直接用map与populate结合封装bean属性
        System.out.println(WebUtil.copyToBeanNew(request, Employee.class));
        response.getWriter().write("done");
    }
}

package cn.young.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "FileListServlet",urlPatterns = "/list")
public class FileListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = this.getServletContext().getRealPath("/upload");
        File file = new File(path);
//        file.listFiles();//获取数组列表
        String[] list = file.list();//获取文件名列表
        HashMap<String, String> map = new HashMap<>();
        if (list != null) {
            for (String aList : list) {
                //split("#");这里不能用#号，因为在get请求中#是锚点，不会被发送到Servlet
                //由于split参数是正则，$是一个正则符号，所以要转义
//                String[] temp = aList.split("\\$");
                //也可以用这种转义[]
                String[] temp = aList.split("[$]");
                String handled = aList;
                if (temp.length >= 2) {
                    handled = temp[1];
                }
                map.put(aList, handled);
            }
        }
        request.setAttribute("map", map);
        request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
    }
}

package cn.young.servlet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

//使用Part必须要添加此注解
@MultipartConfig
@WebServlet(name = "UploadServlet", urlPatterns = "/upload1")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ServletInputStream inputStream = request.getInputStream();
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//            System.out.println(line);
//        }
//        bufferedReader.close();
        //如果直接获取file参数，会返回null
//        System.out.println(request.getParameter("file"));
        String savePath = this.getServletContext().getRealPath("upload");
        //获取单个文件上传表单流，Servlet3.0支持
        Part file = request.getPart("file");
        //从流中获取原始头信息：Content-Disposition: form-data; name="photo"; filename="测试文件.txt"
        String content = file.getHeader("Content-Disposition");
        int pos;
        String fileName = "";
        if ((pos = content.lastIndexOf("=")) > -1) {
            fileName = content.substring(pos + 1).replace("\"", "");
            System.out.println(fileName);
        }
        if (!"".equals(fileName)) {//&&file!=null为多余判断，因为fileName是来自于content，content来自于file！
            file.write(savePath + "/" + fileName);
        }
        System.out.println("done");

        //多文件上传时，获取parts接着进行遍历
//        Collection<Part> parts = request.getParts();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/upload1.jsp").forward(request, response);
    }
}

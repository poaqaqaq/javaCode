package cn.young.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name = "DownloadServlet", urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String handled = request.getParameter("handled");
        String fileName = request.getParameter("origin");
        if (fileName != null && !"".equals(fileName.trim())) {
            String realPath = this.getServletContext().getRealPath("/upload/" + fileName);
            File file = new File(realPath);
            response.setHeader("Content-Disposition", "attachment;filename=" + handled);
            FileInputStream in = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int length;
            ServletOutputStream outputStream = response.getOutputStream();
            while ((length = in.read(bytes)) != -1) {
                outputStream.write(bytes, 0, length);
            }
            outputStream.close();
            in.close();
        }
    }
}

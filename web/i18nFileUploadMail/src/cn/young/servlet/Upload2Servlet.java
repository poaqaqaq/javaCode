package cn.young.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Upload2Servlet", urlPatterns = "/upload2")
public class Upload2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        //设置单个文件最大为3M
        fileUpload.setSizeMax(3 * 1024 * 1024);
        //设置总大小为10M
        fileUpload.setFileSizeMax(10 * 1024 * 1024);
        //设置编码，相当于：request.setCharacterEncoding("UTF-8");
        fileUpload.setHeaderEncoding("UTF-8");
        //fileUpload.isMultipartContent(request);//或者是写成下面的静态判断
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> fileItems = fileUpload.parseRequest(request);
                for (FileItem fileItem : fileItems) {
                    //普通表单
                    if (fileItem.isFormField()) {
                        //获取上传的表单名与内容
                        System.out.println(fileItem.getFieldName() + "：" + fileItem.getString());
                    } else {
                        //这两个属性是文件表单特有的
                        //获取上
                        //   传文件名
                        System.out.println("name：" + fileItem.getName());
                        //获取上传文件类型
                        System.out.println("contentType：" + fileItem.getContentType());
                        String savePath = this.getServletContext().getRealPath("/upload");
                        //生成唯一文件名
//                        String uuid = UUID.randomUUID().toString().replace("-", "");
                        SimpleDateFormat s = new SimpleDateFormat("yyyyMMddHHmmss");
                        String uuid = s.format(new Date());
                        //生成File对象，文件名为：uuid+#+真实文件名
                        File file = new File(savePath, uuid + "#" + fileItem.getName());
                        fileItem.write(file);
                        //删除临时文件
                        fileItem.delete();
                        System.out.println("done");
                        System.out.println(new Date().toString());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/upload2.jsp").forward(request, response);
    }
}

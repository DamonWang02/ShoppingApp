import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置编码格式
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();

        // 获得磁盘目录条
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

        // 设置上传路径
        String path = request.getRealPath("/upload");

        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        diskFileItemFactory.setRepository(new File(String.valueOf(path)));

        // 设置缓存大小
        diskFileItemFactory.setSizeThreshold(1024 * 1024);


        // 文件上传处理
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        try {

            List<FileItem> fileItems = servletFileUpload.parseRequest(request);

            for (FileItem fileItem : fileItems) {

                if (fileItem.isFormField()) {

                    // 获取字符串内容，并存人Jason数组中。

                    JSONArray jsonArray = new JSONArray();
                    JSONObject jsonObject = new JSONObject();

                    String data = fileItem.getString("UTF-8");

                    jsonObject.put(data, data);

                    jsonArray.add(jsonObject);

                    out.println(jsonArray);

                } else {

                    // 获取文件名
                    String fileName = fileItem.getName();
                    fileItem.write(new File(path, fileName));
                    out.println(path);
                    out.println("图片上传成功。");
                }
            }

        } catch (Exception e) {

            out.println("文件上传失败。");
            e.printStackTrace();
        }

        // 关闭数据流
        out.flush();
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);

    }
}

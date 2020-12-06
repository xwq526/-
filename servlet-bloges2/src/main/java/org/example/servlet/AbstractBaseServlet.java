package org.example.servlet;

import org.example.exception.AppException;
import org.example.model.JSONResponse;
import org.example.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xuwenqing
 * Date: 2020-12-02
 * Time: 16:11:52
 */
public abstract class AbstractBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        //创建前后端统一的数据格式对象
        JSONResponse json = new JSONResponse();


        //业务解析请求数据，执行业务操作，获取业务操作返回数据
        try {
            Object data = process(req,resp);
            //业务操作成功，设置success=true及业务数据
            json.setSuccess(true);
            json.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
            //业务操作失败，设置success= false，code错误码，message
            //1.处理自定义异常（code，message）.2.其他异常（错误消息可能是英文）
            String code = "unknown";
            String message = "未知错误，请联系管理员";
            if (e instanceof AppException){
                code = ((AppException)e).getCode();
                message = e.getMessage();
            }
            json.setCode(code);
            json.setMessage(message);
        }

        //将统一的数据对象，序列化为json字符串，返回给前端
        PrintWriter pw = resp.getWriter();
        pw.println(JSONUtil.serialize(json));
        pw.flush();
        pw.close();
    }

    protected abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;

}

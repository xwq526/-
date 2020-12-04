package org.example.filter;

import org.example.model.JSONResponse;
import org.example.model.User;
import org.example.util.JSONUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xuwenqing
 * Date: 2020-12-04
 * Time: 16:36:14
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp =(HttpServletResponse)response;
        //访问/jsp/...如果没有登录，跳转/view/login.html
        //访问/login,其他的前端资源（除了jsp的），不校验session(登录注册注销）
        //其他的后端资源，校验session，没有登录返回401的状态码，json字符串，通过就doFilter
      /*  String schema = req.getScheme();//获取协议http
        String host = req.getServerName();//主机ip
        int port = req.getServerPort();//主机端口号
        String contextPath = req.getContextPath();//应用上下文路径*/
        String path = req.getServletPath();//Servlet路径
//        System.out.println(""); //加断点用的
        if (path.startsWith("/js/") || path.startsWith("/static/")
                || path.startsWith("/view/") || path.startsWith("/login")){
            chain.doFilter(request,response);//原生的
        }else {
            //校验
            HttpSession session = req.getSession(false);
            if (session == null){
                //跳转或返回json
                unauthorized(req,resp);
            }else {
                User user = (User) session.getAttribute("user");
                if (user == null){
                    //跳转或者返回json
                    unauthorized(req,resp);
                }else {
                    chain.doFilter(request,response);
                }
            }

        }
    }
    public static void unauthorized(HttpServletRequest req,
                                    HttpServletResponse resq) throws IOException {
        String schema = req.getScheme();//获取协议http
        String host = req.getServerName();//主机ip
        int port = req.getServerPort();//主机端口号
        String contextPath = req.getContextPath();//应用上下文路径
        String path = req.getServletPath();//Servlet路径
        resq.setCharacterEncoding("UTF-8");
        if (path.startsWith("/jsp/")){//前端敏感资源：跳转登录页面
//            resq.setContentType("text/html");//可以不要
            String  basePath =schema+"://"+host+":"+port+contextPath;
            resq.sendRedirect(basePath+"/view/login.html");//重定向
        }else {//后端的敏感资源：状态码401，返回json
            resq.setContentType("application/json");
            resq.setStatus(401);
            JSONResponse json = new JSONResponse();
            json.setCode("LOG000");
            json.setMessage("用户没有登录，不允许访问");
            PrintWriter pw = resq.getWriter();
            pw.println(JSONUtil.serialize(json));
            pw.flush();
            pw.close();
        }
    }
    @Override
    public void destroy() {

    }
}

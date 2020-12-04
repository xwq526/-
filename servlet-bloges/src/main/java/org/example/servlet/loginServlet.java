package org.example.servlet;

import org.example.dao.LoginDAO;
import org.example.exception.AppException;
import org.example.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: xuwenqing
 * Date: 2020-12-02
 * Time: 17:26:44
 */
@WebServlet("/login")
public class loginServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //解析请求数据：
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //根据账号查询数据库
        User user = LoginDAO.query(username);
        //校验账号及密码
        if (user == null){
            throw new AppException("LOG002","用户账号不存在");
        }
        if (!user.getPassword().equals(password)){
            throw new AppException("LOG003","账号或密码错误");
        }
        //校验成功，设置session
        HttpSession session = req.getSession();
        session.setAttribute("user",user);
        return null;

    }
}

package com.nuist.servlet;


import com.nuist.dao.UserLoginDao;
import com.nuist.dao.UserRegDao;
import com.nuist.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/reg")
public class RegServlet extends HttpServlet {
    private static final UserRegDao userRegDao = new UserRegDao();
    private static final UserLoginDao userLoginDao = new UserLoginDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");
        User user = new User(userName, userPwd);
        try {
            if (userLoginDao.getUserByNameAndPwd(userName, userPwd) == null){
                try {
                    if (userRegDao.insertUser(user) > 0){
                        System.out.println("账号注册成功！");
                        resp.sendRedirect("login.html");
                    }else {
                        System.out.println("账号注册失败！");
                        resp.sendRedirect("login.html");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }else{
                System.out.println("账号已经存在！直接登录即可");
                resp.sendRedirect("login.html");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

package com.nuist.servlet;

import com.nuist.dao.UserLoginDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private static final UserLoginDao userLoginDao = new UserLoginDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");
//        Map<String, String[]> hashMap = req.getParameterMap();
//        System.out.println(hashMap);
//        for(String key : hashMap.keySet()){
//            String[] values = hashMap.get(key);
//            for(String value : values){
//                System.out.println(value);
//            }
//        }
//        String url = req.getQueryString();
//        String[] params = url.split("&");
//        for (String param : params) {
//            String[] keyValue = param.split("=");
//            hashMap.put(keyValue[0], keyValue[1]);
//            System.out.println(keyValue[0] + "=" + hashMap.get(keyValue[0]));
//        }
//        System.out.println(hashMap);
        try {
            if (userLoginDao.getUserByNameAndPwd(userName, userPwd) != null){
                System.out.println(userLoginDao.getUserByNameAndPwd(userName, userPwd));
//                req.getRequestDispatcher("mainFrame.html").forward(req, resp);
                resp.sendRedirect("mainFrame.html");
            }else {
                System.out.println("登录失败！");
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

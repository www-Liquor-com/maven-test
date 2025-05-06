package com.nuist.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.Writer;

@WebServlet("/index")
public class IndexServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        System.out.println("hello world!");
        String name = "admin";
        String pwd = "123456";
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        System.out.println(username);
        Writer writer = servletResponse.getWriter();
        if (name.equals(username) && pwd.equals(password)) {
            writer.write("OK!");
        }else {
            writer.write("ERROR!");
        }
        writer.close();
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}

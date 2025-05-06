package com.nuist.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/myHttp", initParams = {@WebInitParam(name = "username", value = "admin")})
public class MyHttpServlet implements Servlet {
    private Integer count = 0;
    private ServletConfig config;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        String name = servletConfig.getInitParameter("username");
        System.out.println(name);

    }

    @Override
    public ServletConfig getServletConfig() {
        return null ;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        synchronized (this){
            count++;
        }
        servletResponse.setContentType("text/html;charset=utf-8");
        PrintWriter out = servletResponse.getWriter();
        out.println("您是第" + count + "个发送请求的人");
        out.println(Thread.currentThread().getName());
//        out.println(config.getInitParameter("username"));
        System.out.println(config.getInitParameter("username"));
        out.close();


    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}

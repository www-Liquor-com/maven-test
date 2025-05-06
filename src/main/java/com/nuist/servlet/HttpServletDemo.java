package com.nuist.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebServlet(urlPatterns = "/http")
public class HttpServletDemo implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();
        System.out.println("客户端发送的请求类型是：" + method);
        if (method.equals("GET")) {
            doGet(request);
        }else if (method.equals("POST")) {
            doPost(request);
        }
    }

    private void doPost(HttpServletRequest request) {
        System.out.println("使用的是Post方法！");
    }

    private void doGet(HttpServletRequest request) {
        System.out.println("使用的是Get方法！");
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}

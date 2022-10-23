package com.example.GROUP2.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Web三大组件
 * ① Servlet概念：运行在服务器端的小程序
 *      一个接口，定义了Java类被浏览器访问到(tomcat识别)的规则。
 * ② web中的过滤器：当访问服务器的资源时，过滤器可以将请求拦截下来，完成一些特殊的功能。
 *      一般用于完成通用的操作。如：登录验证、统一编码处理、敏感字符过滤...
 * ③ ServletContextListener
 *      监听ServletContext对象的创建和销毁
 *
 * 1.使用Servlet原生API（原生就是不会经过DispatcherServlet）
 * @ServletComponentScan(basePackages="com.exam...")指定原生servlet组件都放到哪里
 * @WebServlet(urlPatterns="/my") 效果：直接相应、没有经过Spring的拦截器
 * @WebFilter(urlPatterns = {"/css/*","/images/*"})
 * @WebListener
 * ？？？？(filter用于字符过滤、listener用于初始化作用域数据、interceptor用于拦截请求)
 */
@WebServlet(urlPatterns = "/my")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("66666");
    }
}

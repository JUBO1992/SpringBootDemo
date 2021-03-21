package com.jubo.demo.common.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JUBO
 * @version 1.0.0
 * @date 2021/03/14
 *
 * 用户权限处理
 */
@Component
@WebFilter(urlPatterns = "/*")
public class AccountFilter implements Filter {

    /**
     * 记录不需要登录即可访问的uri
     */
    private final String[] IGNORE_URI = {"/index", "/css/", "/images/", "/js/", "/account/login", "/account/validateAccount"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 系统启动前执行
        System.out.println("----------------AccountFilter Init-----------------");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        String uri = request.getRequestURI();
        // 当前uri是否在ignore里面
        boolean pass = canPassIgnore(uri);
        // System.out.println("uri: " + uri);
        // uri在ignore中的直接放行
        if (pass) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        // 不在ignore里面，则判断是否已登录，从session中找Account
        Object account = request.getSession().getAttribute("account");
        System.out.println("account: " + account);
        if (null == account) {
            response.sendRedirect("/account/login");
            return;
        }

        System.out.println("-----filter-----" + uri);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean canPassIgnore(String uri) {
        for (String val : IGNORE_URI) {
            if (uri.startsWith(val)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}

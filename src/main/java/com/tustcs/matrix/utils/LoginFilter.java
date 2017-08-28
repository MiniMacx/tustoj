package com.tustcs.matrix.utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author L.key.
 * @Date 2017/7/24 19:58
 */
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        httpServletRequest.getRequestDispatcher(httpServletRequest.getServletPath()
                + httpServletRequest.getPathInfo()).forward(httpServletRequest, httpServletResponse);
    }

    public void destroy() {

    }
}

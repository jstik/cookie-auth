package com.cookie.example.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@Component
@Order(1)
public class CookieFilter implements Filter {

    String USER_NAME = "userName";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = ((HttpServletRequest) servletRequest);
        Cookie[] fromRq = httpServletRequest.getCookies();
        if (!StringUtils.isEmpty(servletRequest.getParameter(USER_NAME))) {
            ((HttpServletResponse) servletResponse).setHeader("Set-Cookie", USER_NAME +"=" + servletRequest.getParameter(USER_NAME) + ";");
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (Stream.of(fromRq).filter(cookie -> USER_NAME.equals(cookie.getName())).findAny().isPresent()) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            httpResponse.sendRedirect(String.format("http://localhost:8084/login?action=http://%s:%s%s",
                    httpServletRequest.getServerName(),
                    httpServletRequest.getServerPort(),
                    httpServletRequest.getRequestURI()));
        }
    }

}

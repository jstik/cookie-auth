package com.cookie.example.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.message.AuthException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CookieEndpoint {
    Logger logger = LoggerFactory.getLogger(CookieEndpoint.class);

    @GetMapping("/hello")
    public Object hello(HttpServletRequest httpServletRequest, HttpServletResponse response){
        logger.error("-------cookie----------/n" + httpServletRequest.getCookies().toString());
        return "Hello";
    }

    @GetMapping("/login")
    public Object loginEndpoint(HttpServletRequest httpServletRequest, HttpServletResponse response) throws AuthException {
        logger.error("-------cookie----------" + httpServletRequest.getCookies().toString());
        throw new AuthException();
    }
}

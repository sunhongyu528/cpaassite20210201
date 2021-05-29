package com.sunhongyu.cpaassite20210201.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义403错误
 * @Author
 * @Date 2020/8/19 20:24
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        //1 设置响应状态码 >这里设置403
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json:charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("{\"code\":\"403\",\"msg\":\"无权限,请联络管理员\"}");
        writer.flush();
        writer.close();
    }
}
package com.bishe.demo.common.shiro;

import com.bishe.demo.common.util.Response.ResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 对于没有登录的请求进行拦截,全部返回json信息,覆盖掉shiro原本的跳转login.jsp的拦截方式
public class AjaxPermissionsAuthorizationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        if (isLoginRequest(request, response)) { return true; } // 放行到登录页面   

        // OPTION放行 ???
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (req.getMethod().equals(RequestMethod.OPTIONS.name())) {
            resp.setStatus(HttpStatus.OK.value());
            return true;
        }

        resp.addHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));         // 设置头 因为 shiroconfig 中的 setloginurl跳转的时候会把头丢掉
        resp.setHeader("Access-Control-Allow-Methods", req.getMethod());
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Headers", req.getHeader("Access-Control-Request-Headers"));
        resp.setHeader("Content-Type", "pplication/json;charset=UTF-8");

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode res = mapper.createObjectNode();
        Subject subject = getSubject(request, response);
        System.out.println(subject);
        System.out.println(subject.getPrincipal());

        res.put("status", ResponseCode.NEED_LOGIN.getCode());
        res.put("msg", ResponseCode.NEED_LOGIN.getDesc());
        PrintWriter out = null;

        try {
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json");
            out = response.getWriter();
            out.println(res);
        } catch (IOException e) {
        } finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
        return false;
    }

    // ???
    @Bean
    public FilterRegistrationBean registrationBean(AjaxPermissionsAuthorizationFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }
}
 
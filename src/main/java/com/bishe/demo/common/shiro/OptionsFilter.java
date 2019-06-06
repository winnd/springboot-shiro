package com.bishe.demo.common.shiro;

import org.apache.shiro.web.filter.authc.UserFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 用来处理  Method 为 options 的情况
//          以及跨域问题
public class OptionsFilter extends UserFilter {

    /**
     * 重写shiro的UserFilter，实现通过OPTIONS请求
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            setHeader(httpServletRequest, httpServletResponse);
            return true;
        }
        return super.preHandle(request, response);
    }

    private void setHeader(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", request.getMethod());
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));

        response.setHeader("Content-Type", "pplication/json;charset=UTF-8");
        response.setStatus(HttpStatus.OK.value());
    }
}

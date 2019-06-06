package com.bishe.demo.common.shiro;

import com.bishe.demo.common.util.Response.ResponseCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 对于没有登录的请求进行拦截,全部返回json信息,覆盖掉shiro原本的跳转login.jsp的拦截方式
public class AjaxPermissionAuthorizationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode res = mapper.createObjectNode();
        Subject subject = getSubject(request, response);
        System.out.println(subject);
        System.out.println(subject.getPrincipal());

        res.put("code", ResponseCode.NO_PERMISSION.getCode());
        res.put("msg", ResponseCode.NO_PERMISSION.getDesc());
        PrintWriter out = null;
        HttpServletResponse resp = (HttpServletResponse) response;

        try {
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json");
            out = response.getWriter();
            out.println(res);
        } catch (IOException e) {
        }finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
        return false;
    }

    // ???
    @Bean
    public FilterRegistrationBean registrationBean(AjaxPermissionAuthorizationFilter filter) {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(filter);
        registrationBean.setEnabled(false);
        return registrationBean;
    }
}
 
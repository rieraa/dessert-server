package com.example.desserts.config;

import com.auth0.jwt.interfaces.Claim;
import com.example.desserts.utils.JwtTokenUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.util.Map;

@Component
@WebFilter(filterName = "JwtFilter", urlPatterns = "/*")
public class JwtFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("jwt初始化方法");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;

        response.setCharacterEncoding("UTF-8");
        final String token = request.getHeader("Authorization");

        String requestPath = request.getRequestURI();
        // 登录接口，直接放行
        if (requestPath.contains("/user/login")) {
            chain.doFilter(request, response);
            return;
        }
        if ("OPTIONS".equals(request.getMethod())) { // 是否是 OPTIONS 请求
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(request, response);
        } else {
            if (token == null) {
                response.getWriter().write("没有令牌");
                return;
            }
            Map<String, Claim> userData = JwtTokenUtils.verifyToken(token); // 检验 token
            if (userData == null) {
                response.getWriter().write("令牌非法");
                return;
            }
            int userId = userData.get("userId").asInt(); // 获取用户名
            request.setAttribute("userId", userId); // 设置用户名
            chain.doFilter(req, res); // 过滤成功
        }
    }

    @Override
    public void destroy() {
        System.out.println("jwt销毁方法执行的逻辑");
    }
}

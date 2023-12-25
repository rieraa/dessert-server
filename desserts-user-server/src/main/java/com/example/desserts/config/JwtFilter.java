package com.example.desserts.config;

import com.auth0.jwt.interfaces.Claim;
import com.example.desserts.utils.JwtTokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@Component
@WebFilter(filterName = "JwtFilter", urlPatterns = "/*")
public class JwtFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

    private static final String LOGIN_PATH = "/user/login";
    private static final String REGISTER_PATH = "/user/register";

    private static final String NO_TOKEN_MESSAGE = "用户未登录";
    private static final String ILLEGAL_TOKEN_MESSAGE = "token失效";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic if needed
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;

        response.setCharacterEncoding("UTF-8");
        final String token = request.getHeader("Authorization");

        String requestPath = request.getRequestURI();
        // 登录接口，直接放行
        if (requestPath.contains(LOGIN_PATH) || requestPath.contains(REGISTER_PATH)) {
            chain.doFilter(request, response);
            return;
        }

        if ("OPTIONS".equals(request.getMethod())) {
            // 是否是 OPTIONS 请求
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(request, response);
        } else {
            // 进行鉴权逻辑
            performAuthorization(request, response, token, chain);
        }
    }

    private void performAuthorization(HttpServletRequest request, HttpServletResponse response,
                                      String token, FilterChain chain) throws IOException, ServletException {
        if (token == null) {
            response.getWriter().write(NO_TOKEN_MESSAGE);
            return;
        }
        Map<String, Claim> userData = JwtTokenUtils.verifyToken(token);
        if (userData == null) {
            response.getWriter().write(ILLEGAL_TOKEN_MESSAGE);
            return;
        }

        // 获取用户名
        int userId = userData.get("userId").asInt();
        // 设置用户名
        request.setAttribute("userId", userId);
        // 过滤成功
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Destruction logic if needed
    }
}

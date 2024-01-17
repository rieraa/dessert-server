package com.example.desserts.config;

import com.auth0.jwt.interfaces.Claim;
import com.example.desserts.domain.ResponseResult;
import com.example.desserts.enums.BusinessCode;
import com.example.desserts.utils.JwtTokenUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
@WebFilter(filterName = "JwtFilter", urlPatterns = "/*")
public class JwtFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

    // 设置允许直接访问的路径
    private static final Set<String> ALLOWED_PATHS = new HashSet<>(Arrays.asList("/user/login", "/user/register", "/dessert/getAllDessert"));

    private static final String NO_TOKEN_MESSAGE = "用户未登录";
    private static final String ILLEGAL_TOKEN_MESSAGE = "token失效";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("请求过滤初始化");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;

        // 设置响应字符编码为UTF-8
        response.setCharacterEncoding("UTF-8");

        // 获取请求头中的token
        final String token = request.getHeader("Authorization");
        System.out.println("🚀 ~ file:JwtFilter.java method:doFilter line:48 -----token:" + token);
        

        // 获取请求路径
        String requestPath = request.getRequestURI();

        // 如果请求路径在允许直接访问的路径列表中，则直接放行
        if (ALLOWED_PATHS.stream().anyMatch(allowedPath -> requestPath.contains(allowedPath))) {
            chain.doFilter(request, response);
            return;
        }

        // 如果请求方法为OPTIONS，表示为预检请求，直接放行
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(request, response);
        } else {
            // 进行鉴权逻辑
            performAuthorization(request, response, token, chain);
        }
    }

    /**
     * 鉴权逻辑
     *
     * @param request
     * @param response
     * @param token
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    private void performAuthorization(HttpServletRequest request, HttpServletResponse response,
                                      String token, FilterChain chain) throws IOException, ServletException {
        // 如果token为空，返回用户未登录信息
        if (Objects.equals(token, "")) {
            String jsonResponse = new ObjectMapper().writeValueAsString(ResponseResult.errorResult(BusinessCode.USER_NOT_LOGIN));
            response.setContentType("application/json");
            response.getWriter().write(jsonResponse);
            return;
        }

        // 验证token的合法性，并获取用户数据
        Map<String, Claim> userData = JwtTokenUtils.verifyToken(token);

        // 如果用户数据为空，返回token失效信息
        if (userData == null) {
            String jsonResponse = new ObjectMapper().writeValueAsString(ResponseResult.errorResult(BusinessCode.TOKEN_EXPIRED));
            response.setContentType("application/json");
            response.getWriter().write(jsonResponse);
            return;
        }

        // 获取用户名
        int userId = userData.get("userId").asInt();

        // 设置用户名到请求属性中
        request.setAttribute("userId", userId);

        // 过滤成功，继续处理请求
        chain.doFilter(request, response);
    }

@Override
public void destroy() {
        // 销毁逻辑（如果有需要）
    }
}

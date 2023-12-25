package com.example.desserts.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.desserts.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Slf4j
public class JwtTokenUtils {
    // Token私钥
    private static final String TOKEN_SECRET = "secret";
    // Token过期时长，单位为秒
    private static final long TOKEN_EXPIRE_TIME_SECONDS = 1800L;

    /**
     * 生成用户token,设置token超时时间
     *
     * @return 生成的token
     */
    public static String createToken(User user) {
        Date expireDate = new Date(System.currentTimeMillis() + TOKEN_EXPIRE_TIME_SECONDS * 1000);
        // 创建 Token 的 payload
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        // 生成 JWT Token
        String token = JWT.create()
                .withHeader(map)// 添加头部
                .withClaim("userId", user.getUserId())
                .withExpiresAt(expireDate) // 超时设置,设置过期的日期
                .withIssuedAt(new Date()) // 签发时间
                .sign(Algorithm.HMAC256(TOKEN_SECRET)); // SECRET加密
        return token;
    }

    /**
     * 检验token是否正确
     *
     * @param token 需要校验的token
     * @return 校验是否成功
     */
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        // 去掉Bearer前缀
        token = token.replaceFirst("Bearer\\s+", "").trim();
        try {
            // 设置签名的加密算法：HMAC256
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET); // 私钥需要一致
            JWTVerifier verifier = JWT.require(algorithm).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            // 记录异常信息
            log.info("Token解码异常: " + e.getMessage());
            // 解码异常则抛出异常
            return null;
        }

        return jwt.getClaims();
    }
}

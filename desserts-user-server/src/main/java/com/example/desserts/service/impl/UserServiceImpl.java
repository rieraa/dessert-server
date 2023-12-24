package com.example.desserts.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.desserts.entity.User;
import com.example.desserts.mapper.UserMapper;
import com.example.desserts.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 服务实现类
 * </p>
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    // 混淆密码
    private static final String SALT = "code";

    @Resource
    private UserMapper userMapper;

    @Override
    public User userLogin(String userName, String password, HttpServletRequest request) {

        // 校验是否为空
        if (StringUtils.isAnyBlank(userName, password)) {
            return null;
        }


        // 账户不能包含特殊字符
        String validPaten = "[`~!@#$%^&*()+=|{}':;',\\\\\\\\[\\\\\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Matcher matcher = Pattern.compile(validPaten).matcher(userName);
        if (matcher.find()) {
            return null;
        }

        // 2. 加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + password).getBytes());// todo 注册功能


        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);
        queryWrapper.eq("password", password);
        User user = userMapper.selectOne(queryWrapper);
        //用户不存在
        if (user == null) {
            log.info("登录失败 用户名密码不匹配");
            return null;
        }

        //3. 用户脱敏
//        User safetyUser = getSafetyUser(user);
        // 4. 记录用户的登录态
        //session 将用户的数据存储在session会话中 将safetyUser存储在session中 名称为USER_LOGIN_STATE
        //可以通过request.getSession().getAttribute()取出当前session的客户端数据 来分辨是哪位用户进行登录
        //USER_LOGIN_STATE 的作用就是 若用户进行了登录操作 其session中就会存放对应的内容 若通过上方方法getAttribute时 若没有数据
        //就能判断当前用户未登录
        return user;
    }
}

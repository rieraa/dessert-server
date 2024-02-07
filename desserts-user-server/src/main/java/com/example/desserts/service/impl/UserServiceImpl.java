package com.example.desserts.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.desserts.enums.BusinessCode;
import com.example.desserts.exception.BusinessException;
import com.example.desserts.mapper.UserMapper;
import com.example.desserts.model.entity.User;
import com.example.desserts.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
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
            throw new BusinessException("参数错误", BusinessCode.PARAMS_ERROR.getCode(), "用户名或密码不能为空");
        }

        // 账户不能包含特殊字符
        String validPaten = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Matcher matcher = Pattern.compile(validPaten).matcher(userName);
        if (matcher.find()) {
            throw new BusinessException("参数错误", BusinessCode.PARAMS_ERROR.getCode(), "用户名不能包含特殊字符");
        }

        // 2. 加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + password).getBytes());

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);
        queryWrapper.eq("password", encryptPassword);
        User user = userMapper.selectOne(queryWrapper);

        // 用户不存在
        if (user == null) {
            throw new BusinessException("登录失败", BusinessCode.USER_NOT_FOUND.getCode(), BusinessCode.USER_NOT_FOUND.getMessage());
        }


        return user;

    }

    @Override
    public User userRegister(String userName, String password, String checkPassword) {
        // 1.校验
        if (StringUtils.isAnyBlank(userName, password, checkPassword)) {
            throw new BusinessException("参数错误", BusinessCode.PARAMS_ERROR.getCode(), "用户名、密码不能为空");
        }

        if (userName.length() < 4) {
            throw new BusinessException("参数错误", BusinessCode.PARAMS_ERROR.getCode(), "用户名长度不能小于4");
        }
        if (password.length() < 6 || checkPassword.length() < 6) {
            throw new BusinessException("参数错误", BusinessCode.PARAMS_ERROR.getCode(), "密码长度不能小于6");
        }

        // 账户不能包含特殊字符
        String validPaten = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Matcher matcher = Pattern.compile(validPaten).matcher(userName);
        if (matcher.find()) {
            throw new BusinessException("参数错误", BusinessCode.PARAMS_ERROR.getCode(), "用户名不能包含特殊字符");
        }


        // 密码和校验密码相同
        if (!password.equals(checkPassword)) {
            throw new BusinessException("参数错误", BusinessCode.PARAMS_ERROR.getCode(), "两次密码不一致");
        }

        // 账户不能重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);
        long count = userMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new BusinessException("业务逻辑错误", BusinessCode.USERNAME_ALREADY_EXISTS.getCode(), BusinessCode.USERNAME_ALREADY_EXISTS.getMessage());
        }

        // 2.加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + password).getBytes());

        // 3.插入数据
        User user = new User();
        user.setUserName(userName);
        user.setPassword(encryptPassword);


        int saveResult = userMapper.insert(user);
        if (saveResult <= 0) {
            throw new BusinessException("业务逻辑错误", BusinessCode.BUSINESS_ERROR.getCode(), "用户注册失败");
        }

        queryWrapper.eq("user_id", user.getUserId());

        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public List<User> allUser() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_admin", 0);  // 假设在数据库中，0 表示 false，即非管理员用户
        return userMapper.selectList(queryWrapper);
    }
}

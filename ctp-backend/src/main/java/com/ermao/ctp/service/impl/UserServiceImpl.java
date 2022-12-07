package com.ermao.ctp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ermao.ctp.mapper.UserMapper;
import com.ermao.ctp.pojo.DO.UserDO;
import com.ermao.ctp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ermao
 * Date: 2022/12/7 11:42
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean userRegister(String phone, String password) {
        if (log.isDebugEnabled()) {
            log.debug("UserServiceImpl.userRegister get phone: {}, password: {}", phone, password);
        }
        UserDO userDO = new UserDO(phone, password);
        int insertResult = userMapper.insert(userDO);
        if (log.isDebugEnabled()) {
            log.debug("UserServiceImpl.userRegister return insertResult: {}", insertResult);
        }
        return insertResult > 0;
    }

    @Override
    public Boolean userLogin(String phone, String password) {
        if (log.isDebugEnabled()) {
            log.debug("UserServiceImpl.userLogin get phone: {}, password: {}", phone, password);
        }
        QueryWrapper<UserDO> userDOQueryWrapper = new QueryWrapper<>();
        userDOQueryWrapper.eq("phone", phone).eq("password", password);
        UserDO userDO = userMapper.selectOne(userDOQueryWrapper);
        log.debug("UserServiceImpl.userRegister return userDO: {}", userDO);
        return userDO != null;
    }
}

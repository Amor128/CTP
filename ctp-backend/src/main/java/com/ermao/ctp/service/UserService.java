package com.ermao.ctp.service;


import com.ermao.ctp.pojo.DO.UserDO;

/**
 * @author Ermao
 * Date: 2022/12/7 11:41
 */
public interface UserService {
    Boolean userRegister(String phone, String password);

    Boolean userLogin(String phone, String password);
}

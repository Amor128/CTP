package com.ermao.ctp.service;


import com.ermao.ctp.pojo.DTO.UserDTO;

/**
 * @author Ermao
 * Date: 2022/12/7 11:41
 */
public interface UserService {
    Boolean userRegister(String phone, String password);

    UserDTO getUser(String phone, String password);

    UserDTO getUser(Long userID);

    Boolean updateUser(UserDTO userDTO);
}

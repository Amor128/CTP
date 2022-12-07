package com.ermao.ctp.pojo.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Ermao
 * Date: 2022/12/7 18:23
 */
@Data
public class UserDTO implements Serializable {
    private final static long serialVersionUID = -3760445487636086034L;

    private Long id;

    private String academy;

    private String nickname;

    private String qq;

    private String grade;

    private String school;

    private String sn;

    private String phone;

    private String headPic;

    private Integer status;

    private String password;
}

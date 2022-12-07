package com.ermao.ctp.pojo.DO;

import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;

/**
 * @author Ermao
 * Date: 2022/12/7 11:23
 */
@TableName("user")
public class UserDO {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String academy;

    private String nickname;

    private String grade;

    private String school;

    private String sn;

    private String phone;

    private String head_pic;

    private Integer status;

    private String password;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    public UserDO() {
    }

    public UserDO(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

}

package com.ermao.ctp.pojo.DTO;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ermao
 * Date: 2022/12/11 15:16
 */
@Data
public class GoodsDetailDTO {
    private Long id;

    private String photo;

    private String name;

    private Integer buyPrice;

    private Integer sellPrice;

    private LocalDateTime createTime;

    private String transPlace;

    private Long userID;

    private String school;

    private String academy;

    private String grade;

    private String nickname;

    private String phone;

    private String qq;

    private String content;
}

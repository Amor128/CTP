package com.ermao.ctp.pojo.DTO;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ermao
 * Date: 2022/12/11 23:47
 */
@Data
public class WantDetailDTO {
    private Long id;

    private String name;

    private String content;

    private Integer sellPrice;

    private String transPlace;

    private LocalDateTime createTime;

    private Long userID;

    private String nickname;

    private String phone;

    private String headPic;

    private String qq;
}

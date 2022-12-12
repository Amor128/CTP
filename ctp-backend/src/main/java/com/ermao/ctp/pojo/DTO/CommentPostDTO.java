package com.ermao.ctp.pojo.DTO;

import lombok.Data;

/**
 * @author Ermao
 * Date: 2022/12/12 22:16
 */
@Data
public class CommentPostDTO {
    private Long userID;

    private Long goodsID;

    private String replyTo;

    private String content;
}

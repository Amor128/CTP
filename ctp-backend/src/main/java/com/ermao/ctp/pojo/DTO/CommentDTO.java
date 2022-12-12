package com.ermao.ctp.pojo.DTO;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ermao
 * Date: 2022/12/12 21:58
 */
@Data
public class CommentDTO {
    private Long id;

    private String content;

    private String replyTo;

    private Long goodsID;

    private Long userID;

    private String nickname;

    private String headPic;

    private LocalDateTime createTime;
}

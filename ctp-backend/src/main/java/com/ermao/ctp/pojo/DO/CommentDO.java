package com.ermao.ctp.pojo.DO;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ermao
 * Date: 2022/12/12 21:54
 */
@Data
@TableName("comment")
public class CommentDO {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String content;

    private String replyTo;

    @TableField("goods_id")
    private Long goodsID;

    @TableField("user_id")
    private Long userID;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}

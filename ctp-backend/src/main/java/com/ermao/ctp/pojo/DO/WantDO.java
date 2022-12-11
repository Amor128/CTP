package com.ermao.ctp.pojo.DO;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ermao
 * Date: 2022/12/11 17:21
 */
@TableName("want")
@Data
public class WantDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String content;

    private String name;

    private Integer sellPrice;

    private String transPlace;

    @TableField(fill = FieldFill.INSERT)
    private Integer viewNumber;

    @TableField("user_id")
    private Long userID;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}

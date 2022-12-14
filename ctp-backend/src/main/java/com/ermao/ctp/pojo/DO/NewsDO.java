package com.ermao.ctp.pojo.DO;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ermao
 * Date: 2022/12/14 16:43
 */
@TableName("news")
@Data
public class NewsDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String title;

    private String content;

    private Integer sort;

    private Integer viewNumber;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}

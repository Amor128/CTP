package com.ermao.ctp.pojo.DO;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ermao
 * Date: 2022/12/11 14:31
 */
@Data
@TableName("goods_category")
public class CategoryDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String icon;

    private String name;

    private Integer sort;

    @TableField("parent_id")
    private Long parentID;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}

package com.ermao.ctp.pojo.DO;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ermao
 * Date: 2022/12/11 15:11
 */
@Data
@TableName("goods")
public class GoodsDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Integer buyPrice;

    private String content;

    private Integer flag;

    private String name;

    private String photo;

    private Integer recommend;

    private Integer sellPrice;

    @TableField(fill = FieldFill.INSERT)
    private Integer status;

    @TableField("goods_category_id")
    private Long goodsCategoryID;

    @TableField("user_id")
    private Long userID;

    @TableField(fill = FieldFill.INSERT)
    private Integer viewNumber;

    private String transPlace;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}

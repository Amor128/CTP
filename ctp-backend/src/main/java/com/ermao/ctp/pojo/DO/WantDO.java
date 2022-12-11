package com.ermao.ctp.pojo.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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

    private String viewNumber;

    private Long userID;
}

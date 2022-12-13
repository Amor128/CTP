package com.ermao.ctp.pojo.DTO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ermao
 * Date: 2022/12/13 13:20
 */
@Data
public class GoodsManagerDTO {

    private Long id;

    private String photo;

    private String name;

    private String content;

    private String status;

    private LocalDateTime createTime;
}

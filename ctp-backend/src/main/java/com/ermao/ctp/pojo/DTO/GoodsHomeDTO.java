package com.ermao.ctp.pojo.DTO;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ermao
 * Date: 2022/12/11 17:44
 */
@Data
public class GoodsHomeDTO {
    private Long id;

    private String photo;

    private String name;

    private LocalDateTime createTime;
}

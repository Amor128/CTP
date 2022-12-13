package com.ermao.ctp.pojo.DTO;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ermao
 * Date: 2022/12/13 13:51
 */
@Data
public class GoodsUpdateDTO {
    private Long id;

    private String name;

    private String content;

    private String photo;

    private Integer status;

    private Integer buyPrice;

    private Integer sellPrice;

    private String transPlace;

    private Long goodsCategoryID;

}

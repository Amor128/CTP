package com.ermao.ctp.pojo.DTO;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Ermao
 * Date: 2022/12/11 17:09
 */
@Data
public class GoodsPostDTO {

    private Long userID;

    private String photo;

    private String name;

    private String content;

    private Integer buyPrice;

    private Integer sellPrice;

    private String transPlace;

    private Long goodsCategoryID;
}

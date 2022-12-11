package com.ermao.ctp.pojo.DTO;

import lombok.Data;

/**
 * @author Ermao
 * Date: 2022/12/11 17:25
 */
@Data
public class WantPostDTO {

    private Long userID;

    private String content;

    private String name;

    private Integer sellPrice;

    private String transPlace;
}

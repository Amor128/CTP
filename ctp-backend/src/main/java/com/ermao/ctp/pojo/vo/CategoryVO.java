package com.ermao.ctp.pojo.vo;

import lombok.Data;

/**
 * @author Ermao
 * Date: 2022/12/14 15:48
 */
@Data
public class CategoryVO {
    private Long id;

    private String name;

    private Long parentID;
}

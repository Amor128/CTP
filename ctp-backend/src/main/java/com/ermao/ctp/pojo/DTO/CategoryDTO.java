package com.ermao.ctp.pojo.DTO;

import lombok.Data;

import java.util.List;

/**
 * @author Ermao
 * Date: 2022/12/11 14:38
 */
@Data
public class CategoryDTO {
    private Long id;

    private String name;

    private List<CategoryDTO> children;
}

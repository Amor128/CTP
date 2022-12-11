package com.ermao.ctp.service;

import com.ermao.ctp.pojo.DTO.CategoryDTO;

import java.util.List;

/**
 * @author Ermao
 * Date: 2022/12/11 14:37
 */
public interface CategoryService {
    List<CategoryDTO> listCategories();
}

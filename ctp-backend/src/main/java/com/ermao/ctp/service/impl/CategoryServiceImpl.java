package com.ermao.ctp.service.impl;

import com.ermao.ctp.mapper.CategoryMapper;
import com.ermao.ctp.pojo.DO.CategoryDO;
import com.ermao.ctp.pojo.DTO.CategoryDTO;
import com.ermao.ctp.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ermao
 * Date: 2022/12/11 14:44
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDTO> listCategories() {
        List<CategoryDO> categoryList = categoryMapper.selectList(null);
        HashMap<Long, CategoryDTO> map = new HashMap<>();

        categoryList.forEach(categoryDO -> {
            if (categoryDO.getParentID() == null) {
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setName(categoryDO.getName());
                categoryDTO.setId(categoryDO.getId());
                categoryDTO.setChildren(new ArrayList<>());
                map.put(categoryDTO.getId(), categoryDTO);
            }
        });
        categoryList.forEach(categoryDO -> {
            if (categoryDO.getParentID() != null) {
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setName(categoryDO.getName());
                categoryDTO.setId(categoryDO.getId());
                categoryDTO.setChildren(new ArrayList<>());
                map.get(categoryDO.getParentID()).getChildren().add(categoryDTO);
            }
        });
        return new ArrayList<>(map.values());
    }
}

package com.ermao.ctp.controller.api;

import com.ermao.ctp.pojo.DTO.CategoryDTO;
import com.ermao.ctp.service.CategoryService;
import com.ermao.ctp.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ermao
 * Date: 2022/12/11 14:35
 */
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public Response listCategories() {
        List<CategoryDTO> categoryDTOS = categoryService.listCategories();
        return Response.ok(categoryDTOS);
    }
}

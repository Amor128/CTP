package com.ermao.ctp.controller.api;

import com.ermao.ctp.pojo.DTO.CategoryDTO;
import com.ermao.ctp.pojo.vo.CategoryVO;
import com.ermao.ctp.service.CategoryService;
import com.ermao.ctp.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/admin")
    public Response adminListCategories() {
        List<CategoryVO> categoryVOS = categoryService.adminListCategories();
        return Response.ok(categoryVOS);
    }

    @GetMapping("/parent")
    public Response listParentCategories() {
        List<CategoryVO> categoryVOS = categoryService.listParentCategories();
        return Response.ok(categoryVOS);
    }

    @PutMapping
    public Response updateCategory(@RequestBody CategoryVO categoryVO) {
        return categoryService.updateCategory(categoryVO) > 0 ? Response.ok() : Response.fail();
    }

    @PostMapping
    public Response InsertCategory(@RequestBody CategoryVO categoryVO) {
        return categoryService.insertCategory(categoryVO) > 0 ? Response.ok() : Response.fail();
    }
}

package com.ermao.ctp.controller.api;

import com.ermao.ctp.pojo.DTO.GoodsDetailDTO;
import com.ermao.ctp.pojo.DTO.GoodsHomeDTO;
import com.ermao.ctp.pojo.DTO.GoodsPostDTO;
import com.ermao.ctp.service.GoodsService;
import com.ermao.ctp.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ermao
 * Date: 2022/12/11 16:39
 */
@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    private GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("/{id}")
    public Response getGoodsDetail(@PathVariable Long id) {
        GoodsDetailDTO goodsDetail = goodsService.getGoodsDetail(id);
        return goodsDetail == null ? Response.fail() : Response.ok(goodsDetail);
    }

    @GetMapping("/home")
    public Response getGoodsDetail() {
        List<GoodsHomeDTO> list = goodsService.listHomeGoods();
        return (list == null || list.size() == 0) ? Response.fail() : Response.ok(list);
    }

    @PostMapping
    public Response insertGoods(@RequestBody GoodsPostDTO goodsPostDTO) {
        Integer res = goodsService.insertGoods(goodsPostDTO);
        return res > 0 ? Response.ok() : Response.fail();
    }

    @PutMapping("/id")
    public Response insertGoods(@PathVariable Long id, @RequestBody GoodsPostDTO goodsPostDTO) {
        Integer res = goodsService.insertGoods(goodsPostDTO);
        return res > 0 ? Response.ok() : Response.fail();
    }
}

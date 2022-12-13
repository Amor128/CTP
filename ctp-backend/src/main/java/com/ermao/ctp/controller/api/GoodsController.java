package com.ermao.ctp.controller.api;

import com.ermao.ctp.pojo.DO.GoodsDO;
import com.ermao.ctp.pojo.DTO.*;
import com.ermao.ctp.service.GoodsService;
import com.ermao.ctp.utils.MyPage;
import com.ermao.ctp.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Ermao
 * Date: 2022/12/11 16:39
 */
@Slf4j
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

    @GetMapping
    public Response listGoods(@RequestParam("page") Long page,
                              @RequestParam("perPage") Long perPage,
                              @RequestParam(name = "category", required = false) Long category,
                              @RequestParam(name = "name", required = false) String name) {
        MyPage res = null;
        if (category != null) {
            res = goodsService.getGoodsPageByCategory(page, perPage, category);
        }
        if (name != null) {
            res = goodsService.getGoodsPageByName(page, perPage, name);
        }
        if (res == null) {
            return Response.fail();
        }
        return Response.ok(res);
    }

    @GetMapping("/filter")
    public Response listGoodsManager(@RequestParam(name = "userID") Long userID) {

        List<GoodsManagerDTO> list = goodsService.listGoods(userID);
        if (list != null) {
            return Response.ok(list);
        }
        return Response.fail();
    }

    @PutMapping("/{goodsID}")
    public Response updateGoods(@PathVariable("goodsID") Long goodsID, @RequestBody GoodsUpdateDTO goodsUpdateDTO) {

        Integer res = goodsService.updateGoods(goodsID, goodsUpdateDTO);
        return res > 0 ? Response.ok() : Response.fail();
    }
}

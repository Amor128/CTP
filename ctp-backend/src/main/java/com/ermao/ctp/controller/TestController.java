package com.ermao.ctp.controller;

import com.ermao.ctp.mapper.GoodsMapper;
import com.ermao.ctp.pojo.DTO.GoodsDetailDTO;
import com.ermao.ctp.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Ermao
 * Date: 2022/12/11 15:57
 */
@RestController
public class TestController {

    @Autowired
    private GoodsMapper goodsMapper;

    @GetMapping("/test")
    public Response test() {
        GoodsDetailDTO goodsDetail = goodsMapper.getGoodsDetail(1L);
        return Response.ok(goodsDetail);
    }
}

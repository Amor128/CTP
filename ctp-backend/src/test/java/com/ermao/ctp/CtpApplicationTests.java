package com.ermao.ctp;

import com.ermao.ctp.mapper.GoodsMapper;
import com.ermao.ctp.pojo.DTO.GoodsDetailDTO;
import com.ermao.ctp.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class CtpApplicationTests {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsService goodsService;

    @Test
    void testSQL() {
        GoodsDetailDTO goodsDetail = goodsMapper.getGoodsDetail(1L);
        System.out.println(goodsDetail);
    }

    @Test
    void insertGoods() {
        HashMap<String, Object> map = new HashMap<>();
    }
}

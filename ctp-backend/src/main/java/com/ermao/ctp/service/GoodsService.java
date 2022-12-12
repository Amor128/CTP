package com.ermao.ctp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ermao.ctp.pojo.DTO.GoodsDetailDTO;
import com.ermao.ctp.pojo.DTO.GoodsHomeDTO;
import com.ermao.ctp.pojo.DTO.GoodsPostDTO;
import com.ermao.ctp.utils.MyPage;

import java.util.List;

/**
 * @author Ermao
 * Date: 2022/12/11 16:31
 */
public interface GoodsService {
    GoodsDetailDTO getGoodsDetail(Long id);

    List<GoodsHomeDTO> listHomeGoods();

    Integer insertGoods(GoodsPostDTO goodsPostDTO);

    Integer updateGoods(Long id, GoodsPostDTO goodsPostDTO);

    MyPage getGoodsPageByCategory(Long page, Long perPage, Long category);

    MyPage getGoodsPageByName(Long page, Long perPage, String name);
}

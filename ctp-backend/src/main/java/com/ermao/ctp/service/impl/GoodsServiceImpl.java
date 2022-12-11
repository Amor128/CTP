package com.ermao.ctp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ermao.ctp.mapper.GoodsMapper;
import com.ermao.ctp.pojo.DO.GoodsDO;
import com.ermao.ctp.pojo.DTO.GoodsDetailDTO;
import com.ermao.ctp.pojo.DTO.GoodsHomeDTO;
import com.ermao.ctp.pojo.DTO.GoodsPostDTO;
import com.ermao.ctp.service.GoodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ermao
 * Date: 2022/12/11 16:32
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    private GoodsMapper goodsMapper;

    @Autowired
    public GoodsServiceImpl(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    @Override
    public GoodsDetailDTO getGoodsDetail(Long id) {
        return goodsMapper.getGoodsDetail(id);
    }

    @Override
    public Integer insertGoods(GoodsPostDTO goodsPostDTO) {
        GoodsDO goodsDO = new GoodsDO();
        BeanUtils.copyProperties(goodsPostDTO, goodsDO);
        return goodsMapper.insert(goodsDO);
    }

    @Override
    public Integer updateGoods(Long id, GoodsPostDTO goodsPostDTO) {
        GoodsDO goodsDO = new GoodsDO();
        BeanUtils.copyProperties(goodsPostDTO, goodsDO);
        goodsDO.setId(id);
        return goodsMapper.updateById(goodsDO);
    }

    @Override
    public List<GoodsHomeDTO> listHomeGoods() {
        List<GoodsHomeDTO> res = new ArrayList<>(9);
        QueryWrapper<GoodsDO> wrapper = new QueryWrapper<>();
        wrapper.orderBy(true, false,"create_time")
                .eq("recommend", 1).last("limit 4");
        List<GoodsDO> goodsList = goodsMapper.selectList(wrapper);

        goodsList.forEach(goodsDO -> {
            GoodsHomeDTO goodsHomeDTO = new GoodsHomeDTO();
            BeanUtils.copyProperties(goodsDO, goodsHomeDTO);
            res.add(goodsHomeDTO);
        });
        return res;
    }
}

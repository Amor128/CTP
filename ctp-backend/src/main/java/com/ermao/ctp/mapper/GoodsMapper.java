package com.ermao.ctp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ermao.ctp.pojo.DO.GoodsDO;
import com.ermao.ctp.pojo.DTO.GoodsDetailDTO;
import com.ermao.ctp.pojo.DTO.GoodsHomeDTO;
import com.ermao.ctp.pojo.DTO.GoodsManagerDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Ermao
 * Date: 2022/12/11 15:56
 */
@Mapper
public interface GoodsMapper extends BaseMapper<GoodsDO> {
    GoodsDetailDTO getGoodsDetail(@Param("id") Long id);

    List<GoodsHomeDTO> getGoodsPageByCategory(IPage<GoodsHomeDTO> page, @Param("category") Long category);
    List<GoodsHomeDTO> getGoodsPageByName(IPage<GoodsHomeDTO> page, @Param("name") String name);

    List<GoodsManagerDTO> listGoods(@Param("userID") Long userID);
}

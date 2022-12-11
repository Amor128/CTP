package com.ermao.ctp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ermao.ctp.pojo.DO.GoodsDO;
import com.ermao.ctp.pojo.DTO.GoodsDetailDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Ermao
 * Date: 2022/12/11 15:56
 */
@Mapper
public interface GoodsMapper extends BaseMapper<GoodsDO> {
    GoodsDetailDTO getGoodsDetail(@Param("id") Long id);

}

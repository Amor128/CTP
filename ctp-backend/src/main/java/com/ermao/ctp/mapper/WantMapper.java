package com.ermao.ctp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ermao.ctp.pojo.DO.WantDO;
import com.ermao.ctp.pojo.DTO.WantDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Ermao
 * Date: 2022/12/11 17:30
 */
@Mapper
public interface WantMapper extends BaseMapper<WantDO> {

    List<WantDetailDTO> getWantPage(IPage<WantDetailDTO> page);
}

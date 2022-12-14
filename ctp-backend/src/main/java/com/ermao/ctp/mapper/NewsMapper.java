package com.ermao.ctp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ermao.ctp.pojo.DO.NewsDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Ermao
 * Date: 2022/12/14 16:47
 */
@Mapper
public interface NewsMapper extends BaseMapper<NewsDO> {
}

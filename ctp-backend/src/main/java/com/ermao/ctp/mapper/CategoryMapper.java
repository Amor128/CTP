package com.ermao.ctp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ermao.ctp.pojo.DO.CategoryDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author Ermao
 * Date: 2022/12/11 14:44
 */
@Mapper
public interface CategoryMapper extends BaseMapper<CategoryDO> {
}

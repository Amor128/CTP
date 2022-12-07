package com.ermao.ctp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ermao.ctp.pojo.DO.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Ermao
 * Date: 2022/12/7 11:39
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}

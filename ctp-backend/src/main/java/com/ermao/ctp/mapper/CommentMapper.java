package com.ermao.ctp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ermao.ctp.pojo.DO.CommentDO;
import com.ermao.ctp.pojo.DTO.CommentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Ermao
 * Date: 2022/12/12 22:03
 */
@Mapper
public interface CommentMapper extends BaseMapper<CommentDO> {
    List<CommentDTO> listComments(@Param("id") Long goodsID);
}

package com.ermao.ctp.service.impl;

import com.ermao.ctp.mapper.CommentMapper;
import com.ermao.ctp.pojo.DO.CommentDO;
import com.ermao.ctp.pojo.DTO.CommentDTO;
import com.ermao.ctp.pojo.DTO.CommentPostDTO;
import com.ermao.ctp.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ermao
 * Date: 2022/12/12 22:02
 */
@Service
public class CommentServiceImpl implements CommentService {

    private CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<CommentDTO> listComments(Long id) {
        return commentMapper.listComments(id);
    }

    @Override
    public List<CommentDTO> listComments() {
        return commentMapper.adminListComments();
    }

    @Override
    public Integer insertComment(CommentPostDTO commentPostDTO) {
        CommentDO commentDO = new CommentDO();
        BeanUtils.copyProperties(commentPostDTO, commentDO);
        return commentMapper.insert(commentDO);
    }

    @Override
    public Integer removeComment(Long id) {
        return commentMapper.deleteById(id);
    }
}

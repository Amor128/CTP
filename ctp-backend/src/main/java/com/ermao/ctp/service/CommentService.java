package com.ermao.ctp.service;

import com.ermao.ctp.pojo.DTO.CommentDTO;
import com.ermao.ctp.pojo.DTO.CommentPostDTO;

import java.util.List;

/**
 * @author Ermao
 * Date: 2022/12/12 22:01
 */
public interface CommentService {
    List<CommentDTO> listComments(Long id);

    List<CommentDTO> listComments();

    Integer insertComment(CommentPostDTO commentPostDTO);

    Integer removeComment(Long id);
}

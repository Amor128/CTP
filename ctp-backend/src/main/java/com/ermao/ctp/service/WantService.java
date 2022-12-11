package com.ermao.ctp.service;

import com.ermao.ctp.pojo.DTO.WantPostDTO;

/**
 * @author Ermao
 * Date: 2022/12/11 17:29
 */
public interface WantService {
    Integer insertWant(WantPostDTO wantPostDTO);

    Integer updateWant(Long id, WantPostDTO wantPostDTO);


}

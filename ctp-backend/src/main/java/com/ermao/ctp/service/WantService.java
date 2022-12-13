package com.ermao.ctp.service;

import com.ermao.ctp.pojo.DO.WantDO;
import com.ermao.ctp.pojo.DTO.WantPostDTO;
import com.ermao.ctp.utils.MyPage;

import java.util.List;

/**
 * @author Ermao
 * Date: 2022/12/11 17:29
 */
public interface WantService {
    Integer insertWant(WantPostDTO wantPostDTO);

    Integer updateWant(Long id, WantPostDTO wantPostDTO);

    MyPage getWantPage(Long page, Long perPage);

    Integer removeWant(Long wantID);

    List<WantDO> listMyWant(Long userID);
}

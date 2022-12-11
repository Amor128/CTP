package com.ermao.ctp.service.impl;

import com.ermao.ctp.mapper.WantMapper;
import com.ermao.ctp.pojo.DO.WantDO;
import com.ermao.ctp.pojo.DTO.WantPostDTO;
import com.ermao.ctp.service.WantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ermao
 * Date: 2022/12/11 17:29
 */
@Service
public class WantServiceImpl implements WantService {

    private WantMapper wantMapper;

    @Autowired
    public WantServiceImpl(WantMapper wantMapper) {
        this.wantMapper = wantMapper;
    }

    @Override
    public Integer insertWant(WantPostDTO wantPostDTO) {
        WantDO wantDO = new WantDO();
        BeanUtils.copyProperties(wantPostDTO, wantDO);
        return wantMapper.insert(wantDO);
    }

    @Override
    public Integer updateWant(Long id, WantPostDTO wantPostDTO) {
        WantDO wantDO = new WantDO();
        BeanUtils.copyProperties(wantPostDTO, wantDO);
        wantDO.setId(id);
        return wantMapper.updateById(wantDO);
    }
}

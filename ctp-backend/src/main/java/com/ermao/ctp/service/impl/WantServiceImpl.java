package com.ermao.ctp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ermao.ctp.mapper.WantMapper;
import com.ermao.ctp.pojo.DO.WantDO;
import com.ermao.ctp.pojo.DTO.WantDetailDTO;
import com.ermao.ctp.pojo.DTO.WantPostDTO;
import com.ermao.ctp.service.WantService;
import com.ermao.ctp.utils.MyPage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public MyPage getWantPage(Long page, Long perPage) {
        Page<WantDetailDTO> myPage = new Page<WantDetailDTO>().setCurrent(page).setSize(perPage);

        List<WantDetailDTO> list = wantMapper.getWantPage(myPage);
        return new MyPage(myPage.getCurrent(), myPage.getSize(), myPage.getTotal(), list);
    }

    @Override
    public Integer removeWant(Long wantID) {
        return wantMapper.deleteById(wantID);
    }

    @Override
    public List<WantDO> listMyWant(Long userID) {
        return wantMapper.selectList(new QueryWrapper<WantDO>().eq("user_id", userID));
    }
}

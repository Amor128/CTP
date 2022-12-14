package com.ermao.ctp.service.impl;

import com.ermao.ctp.mapper.NewsMapper;
import com.ermao.ctp.pojo.DO.NewsDO;
import com.ermao.ctp.pojo.vo.NewsVO;
import com.ermao.ctp.service.NewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ermao
 * Date: 2022/12/14 16:47
 */
@Service
public class NewsServiceImpl implements NewsService {

    private NewsMapper newsMapper;

    @Autowired
    public NewsServiceImpl(NewsMapper newsMapper) {
        this.newsMapper = newsMapper;
    }

    @Override
    public Integer insertNews(NewsVO newsVO) {
        NewsDO newsDO = new NewsDO();
        BeanUtils.copyProperties(newsVO, newsDO);
        return newsMapper.insert(newsDO);
    }

    @Override
    public Integer updateNews(NewsVO newsVO) {
        NewsDO newsDO = new NewsDO();
        BeanUtils.copyProperties(newsVO, newsDO);
        return newsMapper.updateById(newsDO);
    }

    @Override
    public List<NewsVO> listNews() {
        List<NewsDO> list = newsMapper.selectList(null);
        List<NewsVO> res = new ArrayList<>();
        list.forEach(item -> {
            NewsVO newsVO = new NewsVO();
            BeanUtils.copyProperties(item, newsVO);
            res.add(newsVO);
        });
        return res;
    }

    @Override
    public Integer removeNews(Long id) {
        return newsMapper.deleteById(id);
    }
}

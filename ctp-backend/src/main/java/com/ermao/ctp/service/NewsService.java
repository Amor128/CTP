package com.ermao.ctp.service;

import com.ermao.ctp.pojo.vo.NewsVO;

import java.util.List;

/**
 * @author Ermao
 * Date: 2022/12/14 16:46
 */
public interface NewsService {
    Integer insertNews(NewsVO newsVO);

    Integer removeNews(Long id);

    List<NewsVO> listNews();

    Integer updateNews(NewsVO newsVO);
}

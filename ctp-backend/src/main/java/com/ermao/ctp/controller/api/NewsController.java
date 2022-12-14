package com.ermao.ctp.controller.api;

import com.ermao.ctp.pojo.vo.NewsVO;
import com.ermao.ctp.service.NewsService;
import com.ermao.ctp.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ermao
 * Date: 2022/12/11 17:38
 */
@RestController
@RequestMapping("/api/news")
public class NewsController {

    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping
    public Response postNews(@RequestBody NewsVO newsVO) {
        return newsService.insertNews(newsVO) > 0 ? Response.ok() : Response.fail();
    }

    @PutMapping
    public Response updateNews(@RequestBody NewsVO newsVO) {
        return newsService.updateNews(newsVO) > 0 ? Response.ok() : Response.fail();
    }

    @GetMapping
    public Response getNewsLIst() {
            List<NewsVO> res = newsService.listNews();
            return res != null ? Response.ok(res) : Response.fail();
    }

    @DeleteMapping("/{id}")
    public Response removeNews(@PathVariable("id") Long id) {
        Integer res = newsService.removeNews(id);
        return res > 0 ? Response.ok() : Response.fail();
    }
}

package com.ermao.ctp.controller.api;

import com.ermao.ctp.utils.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ermao
 * Date: 2022/12/11 17:38
 */
@RestController
@RequestMapping("/api/news")
public class NewsController {

    @PostMapping
    public Response postNews() {
        return null;
    }
}

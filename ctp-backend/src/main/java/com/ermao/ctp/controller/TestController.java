package com.ermao.ctp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ermao
 * Date: 2022/12/6 16:12
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "{\"hello\": \"world!\"}";
    }
}

package com.ermao.ctp.controller.api;

import com.ermao.ctp.pojo.DTO.WantPostDTO;
import com.ermao.ctp.service.WantService;
import com.ermao.ctp.utils.MyPage;
import com.ermao.ctp.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ermao
 * Date: 2022/12/11 17:20
 */
@RestController
@RequestMapping("/api/wants")
public class WantController {

    private WantService wantService;

    @Autowired
    public WantController(WantService wantService) {
        this.wantService = wantService;
    }

    @PostMapping
    public Response postWant(@RequestBody WantPostDTO wantPostDTO) {
        Integer res = wantService.insertWant(wantPostDTO);
        return res > 0 ? Response.ok() : Response.fail();
    }

    @PutMapping("/id")
    public Response putWant(@PathVariable Long id, @RequestBody WantPostDTO wantPostDTO) {
        Integer res = wantService.updateWant(id, wantPostDTO);
        return res > 0 ? Response.ok() : Response.fail();
    }

    @GetMapping
    public Response getWantPage(@RequestParam("page") Long page,
                                @RequestParam("perPage") Long perPage) {
        if ((page == null || page < 1) || (perPage == null || perPage < 0)) {
            return Response.fail();
        }
        MyPage res = wantService.getWantPage(page, perPage);
        return Response.ok(res);
    }
}

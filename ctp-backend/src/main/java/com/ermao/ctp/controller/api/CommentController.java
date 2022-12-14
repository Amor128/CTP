package com.ermao.ctp.controller.api;

import com.ermao.ctp.pojo.DTO.CommentDTO;
import com.ermao.ctp.pojo.DTO.CommentPostDTO;
import com.ermao.ctp.service.CommentService;
import com.ermao.ctp.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ermao
 * Date: 2022/12/12 21:51
 */
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public Response listCommentsByGoodsID(@RequestParam("goodsID") Long id) {
        List<CommentDTO> list = commentService.listComments(id);
        if (list != null) {
            return Response.ok(list);
        }
        return Response.fail();
    }

    @DeleteMapping("/{id}")
    public Response removeComment(@PathVariable("id") Long id) {
        return commentService.removeComment(id) > 0 ? Response.ok() : Response.fail();
    }

    @GetMapping("/admin")
    public Response listComment() {
        List<CommentDTO> list = commentService.listComments();
        if (list != null) {
            return Response.ok(list);
        }
        return Response.fail();
    }

    @PostMapping
    public Response postComment(@RequestBody CommentPostDTO commentPostDTO) {
        Integer res = commentService.insertComment(commentPostDTO);
        if (res > 0) {
            return Response.ok();
        }
        return Response.fail();
    }
}

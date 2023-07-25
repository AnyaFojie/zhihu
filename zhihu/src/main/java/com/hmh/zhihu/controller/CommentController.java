package com.hmh.zhihu.controller;

import com.hmh.zhihu.entity.Comment;
import com.hmh.zhihu.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/answer/{answerId}")
    public Comment addAnswerComment(@PathVariable Integer answerId, @RequestBody Comment comment) {
        // 处理回答的评论逻辑
        comment.setTargetType("answer");
        comment.setTargetId(Long.valueOf(answerId));
        commentService.save(comment);
        return comment;
    }

    @PostMapping("/article/{articleId}")
    public Comment addArticleComment(@PathVariable Integer articleId, @RequestBody Comment comment) {
        // 处理文章的评论逻辑
        comment.setTargetType("article");
        comment.setTargetId(Long.valueOf(articleId));
        commentService.save(comment);
        return comment;
    }

    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable Integer id) {
        // 处理删除评论的逻辑
        commentService.removeById(id);
        return "Comment with ID " + id + " has been deleted.";
    }
}
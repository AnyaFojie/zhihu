package com.hmh.zhihu.controller;

import com.hmh.zhihu.services.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/answers")
public class AnswerController {
    @Resource
    private AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    // 回答问题
    @PostMapping("/publish")
    public ResponseEntity<String> publishAnswer(@RequestParam String content,
                                                @RequestParam Long userId,
                                                @RequestParam Long questionId) {
        boolean success = answerService.publishAnswer(content, userId, questionId);
        if (success) {
            return new ResponseEntity<>("回答问题成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("回答问题失败", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
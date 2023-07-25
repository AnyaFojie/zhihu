package com.hmh.zhihu.controller;

import com.hmh.zhihu.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Resource
    private QuestionService questionService;

    // 发布问题
    @PostMapping("/publish")
    public ResponseEntity<String> publishQuestion(@RequestParam String title,
                                                  @RequestParam String content,
                                                  @RequestParam Long userId) {
        boolean success = questionService.publishQuestion(title, content, userId);
        if (success) {
            return new ResponseEntity<>("问题发布成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("问题发布失败", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

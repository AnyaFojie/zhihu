package com.hmh.zhihu.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hmh.zhihu.entity.Answer;

public interface AnswerService extends IService<Answer> {
     boolean publishAnswer(String content, Long userId, Long questionId);
}

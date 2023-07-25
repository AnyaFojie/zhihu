package com.hmh.zhihu.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hmh.zhihu.entity.Question;

public interface QuestionService extends IService<Question> {
     boolean publishQuestion(String title, String content, Long userId);

}

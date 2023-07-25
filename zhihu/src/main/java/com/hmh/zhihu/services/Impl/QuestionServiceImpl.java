package com.hmh.zhihu.services.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmh.zhihu.entity.Question;
import com.hmh.zhihu.entity.User;
import com.hmh.zhihu.mapper.QuestionMapper;
import com.hmh.zhihu.mapper.UserMapper;
import com.hmh.zhihu.services.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {
    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean publishQuestion(String title, String content, Long userId) {
        User user = userMapper.selectById(userId);
        if (user == null) {
            // 用户不存在，发布失败
            return false;
        }

        Question question = new Question();
        question.setTitle(title);
        question.setContent(content);
        question.setUser(user);
        question.setCreatedAt(LocalDateTime.now());

        int rows = questionMapper.insert(question);
        return rows > 0;
    }
}

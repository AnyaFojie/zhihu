package com.hmh.zhihu.services.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmh.zhihu.entity.Answer;
import com.hmh.zhihu.entity.Question;
import com.hmh.zhihu.entity.User;
import com.hmh.zhihu.mapper.AnswerMapper;
import com.hmh.zhihu.mapper.QuestionMapper;
import com.hmh.zhihu.mapper.UserMapper;
import com.hmh.zhihu.services.AnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class AnswerServiceImpl extends ServiceImpl<AnswerMapper, Answer> implements AnswerService {
    @Resource
    private AnswerMapper answerMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private QuestionMapper questionMapper;

    @Override
    public boolean publishAnswer(String content, Long userId, Long questionId) {
        User user = userMapper.selectById(userId);
        if (user == null) {
            // 用户不存在，回答问题失败
            return false;
        }

        Question question = questionMapper.selectById(questionId);
        if (question == null) {
            // 问题不存在，回答问题失败
            return false;
        }

        Answer answer = new Answer();
        answer.setContent(content);
        answer.setUser(user);
        answer.setQuestion(question);
        answer.setCreatedAt(LocalDateTime.now());

        int rows = answerMapper.insert(answer);
        return rows > 0;
    }
}

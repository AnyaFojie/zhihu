package com.hmh.zhihu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("answers")
public class Answer {
    private Long id;
    private String content;
    private User user;
    private Question question;
    private LocalDateTime createdAt;

}

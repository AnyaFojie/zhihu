package com.hmh.zhihu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("questions")
public class Question {

    private Long id;

    private User user;

    private String title;

    private String content;

    private LocalDateTime createdAt;
}

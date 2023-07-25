package com.hmh.zhihu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hmh.zhihu.enums.CommentTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("comments")
public class Comment {
    private Long id;
    private Long userId;
    private String targetType;
    private Long targetId;
    private String content;
    private LocalDateTime createdAt;


}

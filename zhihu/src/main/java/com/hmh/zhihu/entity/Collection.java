package com.hmh.zhihu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("collections")
public class Collection {
     private Long id;            // 收藏ID，主键
    private Long userId;        // 收藏者的用户ID，外键关联至用户表的id字段
    private String targetType;  // 收藏目标类型，可以是问题、回答或文章等
    private Long targetId;      // 收藏目标的ID，外键关联至问题表、回答表或文章表的id字段
    private LocalDateTime createdAt;  // 收藏时间
}

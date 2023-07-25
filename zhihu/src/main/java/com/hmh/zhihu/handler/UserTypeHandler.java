package com.hmh.zhihu.handler;

import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmh.zhihu.entity.User;

import java.io.IOException;

public class UserTypeHandler extends AbstractJsonTypeHandler<User> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected User parse(String json) {
        try {
            return objectMapper.readValue(json, User.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected String toJson(User user) {
        try {
            return objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
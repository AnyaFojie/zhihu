package com.hmh.zhihu.services.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmh.zhihu.entity.Collection;
import com.hmh.zhihu.mapper.CollectionMapper;
import com.hmh.zhihu.services.CollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements CollectionService {
    @Resource
    private CollectionMapper collectionMapper;

    @Override
    public List<Collection> getCollectionsByUserId(Long userId) {
        QueryWrapper<Collection> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return collectionMapper.selectList(wrapper);
    }

    @Override
    public void addCollection(Collection collection) {
        collectionMapper.insert(collection);
    }
}

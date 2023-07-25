package com.hmh.zhihu.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hmh.zhihu.entity.Collection;

import java.util.List;

public interface CollectionService extends IService<Collection> {
     List<Collection> getCollectionsByUserId(Long userId);

    void addCollection(Collection collection);

}

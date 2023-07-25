package com.hmh.zhihu.controller;

import com.hmh.zhihu.entity.Collection;
import com.hmh.zhihu.services.CollectionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/collections")
public class CollectionController {

    @Resource
    private CollectionService collectionService;
    @GetMapping("/{userId}")
    public List<Collection> getCollectionsByUserId(@PathVariable Long userId) {
        return collectionService.getCollectionsByUserId(userId);
    }

    @PostMapping
    public void addCollection(@RequestBody Collection collection) {
        collectionService.addCollection(collection);
    }
}
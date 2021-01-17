package com.lin.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.blog.pojo.model.Type;

import java.util.List;

/**
 * @author lin945
 * @date 2021/1/17 15:03
 */
public interface TypeService extends IService<Type> {
    int saveType(Type type);

    Type getType(Long id);

    Page<Type> getAllType(Page<Type> page);

    List<Type>getAllTypeAndBlog();

    Type getTypeByName(String name);

    int updateType(Type type);

    void deleteType(Long id);
}

package com.lin.blog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.blog.dao.TypeDao;
import com.lin.blog.exception.NotFoundException;
import com.lin.blog.pojo.model.Type;
import com.lin.blog.service.TypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lin945
 * @date 2021/1/17 15:06
 * @description
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeDao, Type> implements TypeService {
    @Override
    public int saveType(Type type) {
        return baseMapper.insert(type);
    }

    @Override
    public Type getType(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Page<Type> getAllType(Page<Type> page) {
       return baseMapper.selectPage(page, null);
    }

    @Override
    public List<Type> getAllTypeAndBlog() {
        return null;
    }

    @Override
    public Type getTypeByName(String name) {
        QueryWrapper<Type> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public int updateType(Type type) {
        Type type1 = getType(type.getId());
        if (type1 == null) {
            throw new NotFoundException("type不存在");
        }
        return baseMapper.updateById(type);
    }

    @Override
    public void deleteType(Long id) {
        baseMapper.deleteById(id);
    }
}

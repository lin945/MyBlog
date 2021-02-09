package com.lin.blog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.blog.dao.UserDao;
import com.lin.blog.pojo.model.User;
import com.lin.blog.service.UserService;
import com.lin.blog.utils.MD5Utils;
import org.springframework.stereotype.Service;

/**
 * @author lin945
 * @date 2021/1/16 14:37
 * @description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Override
    public User checkUser(String userName, String password) {

        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", userName)
                .eq("password", MD5Utils.code(password));
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public User getByName(String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", userName);
      return baseMapper.selectOne(queryWrapper);
    }
}

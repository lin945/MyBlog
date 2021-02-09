package com.lin.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.blog.pojo.model.User;

/**
 * @author lin945
 * @date 2021/1/16 14:35
 */
public interface UserService extends IService<User> {
    /**
     * 登录检查
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    User checkUser(String userName,String password);

    User getByName(String userName);
}

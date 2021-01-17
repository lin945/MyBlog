package com.lin.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.blog.pojo.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author lin945
 * @date 2021/1/16 14:38
 * @description
 *
 */
@Repository
public interface UserDao extends BaseMapper<User> {

}

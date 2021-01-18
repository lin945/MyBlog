package com.lin.blog.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MybatisPlusObjectHandler implements MetaObjectHandler {
/**
 * @Description:添加和跟新自动填充日期
 * @Author CXY
 * @Date 2020/10/2 16:54
 * @Param [metaObject]
 * @Return void
 **/
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

/**
 * @Description:跟新自动填充日期
 * @Author CXY
 * @Date 2020/10/2 16:55
 * @Param [metaObject]
 * @Return void
 **/
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}

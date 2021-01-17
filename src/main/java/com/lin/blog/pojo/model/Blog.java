package com.lin.blog.pojo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_blog")
public class Blog {
    @TableId(value = "id",type= IdType.AUTO)
    private Long id;
    //赞赏
    private String appreciation;
    //可以评论
    private String commentabled;
    private String content;
    private String description;
    private String firstPicture;
    private String flag;
    private String published;
    //推荐
    private String recommend;
    //分享
    private String shareStatement;
    private String title;
    private long views;
    private long typeId;
    private long userId;
    private long commentCount;
    @TableField(value = "create_time",jdbcType = JdbcType.TIMESTAMP)
    private Date createTime;
    @TableField(value = "update_time",jdbcType = JdbcType.TIMESTAMP)
    private Date updateTime;

}

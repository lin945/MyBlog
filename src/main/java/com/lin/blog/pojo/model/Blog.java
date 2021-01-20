package com.lin.blog.pojo.model;

import com.baomidou.mybatisplus.annotation.*;
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
    private boolean appreciation;
    //可以评论
    private boolean commentabled;
    private String content;
    private String description;
    private String firstPicture;
    private String flag;
    private boolean published;
    //推荐
    private boolean recommend;
    //分享
    private boolean shareStatement;
    private String title;
    private long views;
    private long typeId;
    private long userId;
    private long commentCount;
    @TableField(value = "create_time",jdbcType = JdbcType.TIMESTAMP,fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(value = "update_time",jdbcType = JdbcType.TIMESTAMP,fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}

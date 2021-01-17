package com.lin.blog.pojo.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;

/**
 * @author lin945
 * @date 2021/1/16 22:49
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BolgAllInfoVO {
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
    private Date createTime;

    private Date updateTime;
    //Type
    private String typeName;

    //User
    private String nickname;
    private String avatar;
}

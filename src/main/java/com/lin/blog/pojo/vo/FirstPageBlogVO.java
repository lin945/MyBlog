package com.lin.blog.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lin945
 * @date 2021/1/16 21:04
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirstPageBlogVO {
    //Blog
    private Long id;
    private String title;
    private String firstPicture;
    private Integer views;
    private Integer commentCount;
    private Date updateTime;
    private String description;

    //Type
    private String typeName;

    //User
    private String nickname;
    private String avatar;
}

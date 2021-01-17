package com.lin.blog.pojo.vo;

import com.lin.blog.pojo.model.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogAdminQueryVO {
    private Long id;
    private String title;
    private Date updateTime;
    private Boolean recommend;
    private Boolean published;
    private Long typeId;
    private Type type;
}
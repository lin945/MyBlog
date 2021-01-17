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
@TableName("t_comment")
public class Comment {
    @TableId(value = "id",type = IdType.AUTO)
    private long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    @TableField(value = "createTime",jdbcType = JdbcType.TIMESTAMP)
    private Date createTime;
    private long blogId;
    private long parentCommentId;
    private String adminComment;

}

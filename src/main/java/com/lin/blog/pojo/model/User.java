package com.lin.blog.pojo.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.JdbcType;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user")
public class User {
    private Long id;
    private String avatar;
    private String email;
    private String nickname;
    private String password;
    private long type;
    private String username;
    @TableField(value = "create_time",jdbcType = JdbcType.TIMESTAMP,fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(value = "update_time",jdbcType = JdbcType.TIMESTAMP,fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}

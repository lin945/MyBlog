package com.lin.blog.pojo.ao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.JdbcType;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author lin945
 * @date 2021/1/18 17:39
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBlogAO {
    //赞赏
    private boolean appreciation;
    //可以评论
    private boolean commentabled;
    @NotBlank(message = "正文不能为空")
    private String content;
    @NotBlank(message = "描述不能为空")
    private String description;
    @NotBlank(message = "预览图不能为空")
    private String firstPicture;
    private String flag;
    //推荐
    private boolean recommend;
    //分享(转载
    private boolean shareStatement;
    @NotBlank(message = "标题不能为空")
    private String title;

    private long typeId;
}

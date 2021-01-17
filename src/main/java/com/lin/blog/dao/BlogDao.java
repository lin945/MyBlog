package com.lin.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lin.blog.pojo.model.Blog;
import com.lin.blog.pojo.vo.BolgAllInfoVO;
import com.lin.blog.pojo.vo.FirstPageBlogVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author lin945
 * @date 2021/1/16 20:48
 * @description
 */
@Repository
public interface BlogDao extends BaseMapper<Blog> {
    Page<FirstPageBlogVO> getFirstPageBlog(Page<FirstPageBlogVO> page);

    BolgAllInfoVO getBlogInfo(@Param("id") long id);

}

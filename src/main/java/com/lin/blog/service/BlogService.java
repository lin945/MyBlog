package com.lin.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.blog.pojo.model.Blog;
import com.lin.blog.pojo.vo.BolgAllInfoVO;
import com.lin.blog.pojo.vo.FirstPageBlogVO;

import java.util.List;

/**
 * @author lin945
 * @date 2021/1/16 20:49
 */
public interface BlogService extends IService<Blog> {
    //首页现实的博客列表
    Page<FirstPageBlogVO> getAllFirstPageBlog(Page<FirstPageBlogVO> page);

    Blog getBlogById(long id);

    BolgAllInfoVO getBlogInfoById(long id);
}

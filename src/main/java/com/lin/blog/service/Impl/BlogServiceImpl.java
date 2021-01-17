package com.lin.blog.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.blog.dao.BlogDao;
import com.lin.blog.exception.NotFoundException;
import com.lin.blog.pojo.model.Blog;
import com.lin.blog.pojo.vo.BlogAdminQueryVO;
import com.lin.blog.pojo.vo.BolgAllInfoVO;
import com.lin.blog.pojo.vo.FirstPageBlogVO;
import com.lin.blog.service.BlogService;
import com.lin.blog.utils.MarkdownUtils;
import org.springframework.stereotype.Service;


/**
 * @author lin945
 * @date 2021/1/16 20:49
 * @description
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogDao, Blog> implements BlogService {


    @Override
    public Page<FirstPageBlogVO> getAllFirstPageBlog(Page<FirstPageBlogVO> page) {
        return baseMapper.getFirstPageBlog(page);
    }

    @Override
    public Page<BlogAdminQueryVO> getAdminBlogList(Page<BlogAdminQueryVO> page) {
        return baseMapper.getAdminQueryBlogs(page);
    }

    @Override
    public boolean saveBlog(Blog blog) {
        int insert = baseMapper.insert(blog);
        return insert==1;
    }

    @Override
    public boolean updateBlog(Blog blog) {
        int i = baseMapper.updateById(blog);
        return i==1;
    }

    @Override
    public Blog getBlogById(long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public BolgAllInfoVO getBlogInfoById(long id) {
        BolgAllInfoVO blogInfo = baseMapper.getBlogInfo(id);
        if (blogInfo == null) {
            throw new NotFoundException("博客不存在");
        }
        String content =blogInfo.getContent();
        blogInfo.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return blogInfo;
    }
}

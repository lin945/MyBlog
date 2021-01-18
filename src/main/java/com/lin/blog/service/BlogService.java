package com.lin.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.blog.pojo.ao.CreateBlogAO;
import com.lin.blog.pojo.model.Blog;
import com.lin.blog.pojo.vo.BlogAdminQueryVO;
import com.lin.blog.pojo.vo.BolgAllInfoVO;
import com.lin.blog.pojo.vo.FirstPageBlogVO;

/**
 * @author lin945
 * @date 2021/1/16 20:49
 */
public interface BlogService extends IService<Blog> {
    /**首页现实的博客列表
     * @param page 分页对象
     * @return
     */
    Page<FirstPageBlogVO> getAllFirstPageBlog(Page<FirstPageBlogVO> page);

    /**
     * 后台页面blog分页查询
     * @param page 分页对象
     * @return
     */
    Page<BlogAdminQueryVO> getAdminBlogList(Page<BlogAdminQueryVO> page);

    /**
     * 保存
     * @param blog
     * @return
     */
    boolean saveBlog(Blog blog);

    boolean CreateBlog(CreateBlogAO ao);
    /**
     * 更新
     * @param blog
     * @return
     */
    boolean updateBlog(Blog blog);

    /**
     * id获取
     * @param id
     * @return
     */
    Blog getBlogById(long id);

    /**
     * 博客详情页
     * @param id blog id
     * @return
     */
    BolgAllInfoVO getBlogInfoById(long id);
}

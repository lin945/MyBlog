package com.lin.blog.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lin.blog.pojo.ao.CreateBlogAO;
import com.lin.blog.pojo.model.Blog;
import com.lin.blog.pojo.vo.BlogAdminQueryVO;
import com.lin.blog.service.BlogService;
import com.lin.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author lin945
 * @date 2021/1/16 16:55
 * @description
 */
@Controller
@RequestMapping("/admin")
@Validated
public class BlogController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogService blogService;
    @RequestMapping("/blogs")
    public String blogPage(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        Page<BlogAdminQueryVO> queryPage = new Page<>(pageNum, 10);
        Page<BlogAdminQueryVO> adminBlogList = blogService.getAdminBlogList(queryPage);
        model.addAttribute("page", adminBlogList);
        return "admin/blogs";
    }

    @RequestMapping("/blog/input")
    public String blogInputPage(Model model) {
        model.addAttribute("type", typeService.list());
        model.addAttribute("blog", new Blog());
        return "admin/blogs-input";
    }

    //    博客新增
    @PostMapping("/blogs")
    public String post(@Validated CreateBlogAO blogAO, RedirectAttributes attributes, HttpSession session){
        blogService.CreateBlog(blogAO);
        return "redirect:/admin/blogs";
    }
}

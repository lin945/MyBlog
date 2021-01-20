package com.lin.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lin.blog.pojo.model.Blog;
import com.lin.blog.pojo.model.Comment;
import com.lin.blog.pojo.vo.BolgAllInfoVO;
import com.lin.blog.pojo.vo.FirstPageBlogVO;
import com.lin.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author lin945
 * @date 2021/1/8 20:23
 * @description
 */
@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;
    @RequestMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        Page<FirstPageBlogVO> blogVOPage = new Page<>(pageNum, 6);
        Page<FirstPageBlogVO> blogVO= blogService.getAllFirstPageBlog(blogVOPage);
        model.addAttribute("pageInfo", blogVO);
        return "index";
    }
    //    跳转博客详情页面
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        BolgAllInfoVO blogInfoById = blogService.getBlogInfoById(id);
//        List<Comment> comments = commentService.listCommentByBlogId(id);
//        model.addAttribute("comments", comments);
        model.addAttribute("blog",blogInfoById);
        return "blog";
    }

    @RequestMapping("/blog")
    public String blog() {
        return "blog";
    }
    @RequestMapping("/about")
    public String about() {
        return "about";
    }
    @RequestMapping("/archives")
    public String archives() {
        return "archives";
    }
    @RequestMapping("/tags")
    public String tags() {
        return "tags";
    }
    @RequestMapping("/types")
    public String types() {
        return "types";
    }

}

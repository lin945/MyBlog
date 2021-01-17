package com.lin.blog.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lin.blog.pojo.vo.BlogAdminQueryVO;
import com.lin.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lin945
 * @date 2021/1/16 16:55
 * @description
 */
@Controller
@RequestMapping("/admin")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @RequestMapping("/blogs")
    public String blogPage(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        Page<BlogAdminQueryVO> queryPage = new Page<>(pageNum, 10);
        Page<BlogAdminQueryVO> adminBlogList = blogService.getAdminBlogList(queryPage);
        model.addAttribute("page", adminBlogList);
        return "admin/blogs";
    }
    @RequestMapping("/bloginput")
    public String blogInputPage() {
        return "admin/blogs-input";
    }
}

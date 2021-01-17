package com.lin.blog.controller.admin;

import org.springframework.stereotype.Controller;
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

    @RequestMapping("/blogs")
    public String blogPage() {
        return "admin/blogs";
    }
    @RequestMapping("/bloginput")
    public String blogInputPage() {
        return "admin/blogs-input";
    }
}

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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

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

    /**
     * 博客新增页面
     * @param model model
     * @return
     */
    @RequestMapping("/blog/input")
    public String blogInputPage(Model model) {
        model.addAttribute("type", typeService.list());
        model.addAttribute("blog", new Blog());
        return "admin/blogs-input";
    }

    /**    博客新增接口
     * @param blogAO 参数
     * @param attributes
     * @param session
     * @return
     */
    @PostMapping("/blogs")
    public String post(@Validated CreateBlogAO blogAO, RedirectAttributes attributes, HttpSession session){
        boolean b = blogService.CreateBlog(blogAO);
        if (!b) {
            attributes.addFlashAttribute("message", "发布失败");
        }
        return "redirect:/admin/blogs";
    }
    //    删除文章
    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        boolean b = blogService.deleteBlog(id);
        if (b) {
            attributes.addFlashAttribute("message", "删除成功");
        }
        return "redirect:/admin/blogs";
    }
    //    跳转编辑修改文章
    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        Blog blogById = blogService.getBlogById(id);
        model.addAttribute("blog",blogById);
        model.addAttribute("type", typeService.list());
        return "admin/blogs-input";
    }
    //    编辑修改文章
    @PostMapping("/blogs/{id}")
    public String editPost(@Validated CreateBlogAO blogAO , RedirectAttributes attributes,@PathVariable Long id) {
        boolean b = blogService.updateBlog(blogAO, id);
        if(!b){
            attributes.addFlashAttribute("message", "修改失败");
        }else {
            attributes.addFlashAttribute("message", "修改成功");
        }
        return "redirect:/admin/blogs";
    }
}

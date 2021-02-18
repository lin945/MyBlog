package com.lin.blog.controller.admin;

import com.lin.blog.pojo.model.User;
import com.lin.blog.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author lin945
 * @date 2021/1/16 14:49
 * @description
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @RequestMapping()
    public String loginPage() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            session.setAttribute("user", subject.getPrincipal());
            return "admin/index";
        } catch (UnknownAccountException uae) {
            attributes.addFlashAttribute("message", "未知账户");
            // return "未知账户";
        } catch (IncorrectCredentialsException ice) {
            // return "密码不正确";
            attributes.addFlashAttribute("message", "密码不正确");
        } catch (LockedAccountException lae) {
            attributes.addFlashAttribute("message", "账户已锁定");
            //  return "账户已锁定";
        } catch (ExcessiveAttemptsException eae) {
            attributes.addFlashAttribute("message", "用户名或密码错误次数过多");
            // return "用户名或密码错误次数过多";
        } catch (AuthenticationException ae) {
            attributes.addFlashAttribute("message", "用户名或密码不正确");
            // return "用户名或密码不正确！";
        }
        return "redirect:/admin/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        Subject lvSubject=SecurityUtils.getSubject();
        lvSubject.logout();
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}

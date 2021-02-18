package com.lin.blog.config;

import com.lin.blog.pojo.model.User;
import com.lin.blog.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lin945
 * @date 2021/2/9 13:39
 * @description
 */
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        String username =token1.getUsername();
        String password = new String(token1.getPassword());
        User user = userService.getByName(username);
        if (user==null) {
            return null;
        }
            return new SimpleAuthenticationInfo(user, user.getPassword(),getName());
    }
}

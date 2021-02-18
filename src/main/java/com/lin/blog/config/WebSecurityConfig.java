package com.lin.blog.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lin945
 * @date 2021/1/30 21:05
 * @description shiro配置
 */
@Configuration
public class WebSecurityConfig  {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/admin/login", "anon");
        filterChainDefinitionMap.put("/admin/**", "authc");
        filterChainDefinitionMap.put("/admin/logout", "logout");
        bean.setLoginUrl("/admin");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }

    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager(@Qualifier("customRealm") CustomRealm customRealm) {
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(customRealm);
        return defaultSecurityManager;
    }

    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }
}

package com.lin.blog.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author lin945
 * @date 2021/1/16 17:07
 * @description
 */
@Configuration
public class WebConfig {
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginInterceptor())
//                        .addPathPatterns("/admin/**")
//                .excludePathPatterns("/admin","/admin/login"); // 要拦截的地址
//            }
//
//        };
//    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
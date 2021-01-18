package com.lin.blog.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lin945
 * @date 2021/1/14 20:59
 * @description
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request, Exception e) throws Exception {
        log.error("request url:{} ,Exception : {}", request.getRequestURL(), e.getMessage());
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url", request.getRequestURL().toString());
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("error/error");
        return modelAndView;
    }

    @ExceptionHandler(BindException.class)
    public ModelAndView exceptionHandler(HttpServletRequest request, BindException e) throws Exception {
        log.error("request url:{} ,Exception : {}", request.getRequestURL(), e.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url", request.getRequestURL().toString());
        StringBuilder stringBuilder = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach(i->{
            stringBuilder.append(i.getDefaultMessage()).append(" ");
        });
        modelAndView.addObject("exception",stringBuilder);
        modelAndView.setViewName("error/error");
        return modelAndView;
    }

}

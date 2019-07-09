package com.qhit.parking.config;

import com.qhit.parking.interceptor.LogcostInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by 爸爸 on 2019/5/29.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    LogcostInterceptor logcostInterceptor;

    //拦截静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logcostInterceptor)
                .excludePathPatterns("/admin/log")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/logout")
                .excludePathPatterns("/admin/captcha")
                .addPathPatterns("/admin/*")
                .addPathPatterns("/inpatient/*")
                .addPathPatterns("/message/*")
                .addPathPatterns("/notice/*")
                .addPathPatterns("/orders/*")
                .addPathPatterns("/park/*")
                .addPathPatterns("/user/*");
    }


}

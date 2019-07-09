package com.qhit.parking.interceptor;

import com.qhit.parking.entity.Admin;
import com.qhit.parking.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import reactor.util.annotation.Nullable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Configuration
public class LogcostInterceptor  implements HandlerInterceptor{
    @Autowired
    RedisUtil redisUtil;
    //preHandle是在请求执行前执行的
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Admin logAdmin = (Admin)request.getSession().getAttribute("LogAdmin");

        if(logAdmin!=null){
           String logAdminUser = redisUtil.get("LogAdminUser:"+logAdmin.getId());
            System.out.println(logAdminUser);
           if(logAdminUser!=null&&logAdminUser.equals(request.getSession().getId())){
               return true;
           }
        }
            response.sendRedirect("/admin/login");
            return false;

        //返回true,postHandler和afterCompletion方法才能执行
        // 否则false为拒绝执行，起到拦截器控制作用
    }

    //postHandler是在请求结束之后,视图渲染之前执行的,但只有preHandle方法返回true的时候才会执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("执行postHandle");
    }

    //afterCompletion是视图渲染完成之后才执行,同样需要preHandle返回true，
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        //该方法通常用于清理资源等工作
        System.out.println("执行afterCompletion");
    }
}


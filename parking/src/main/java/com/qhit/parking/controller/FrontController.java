package com.qhit.parking.controller;

import com.qhit.parking.entity.Notice;
import com.qhit.parking.entity.Orders;
import com.qhit.parking.entity.Park;
import com.qhit.parking.entity.User;
import com.qhit.parking.service.notice.NoticeService;
import com.qhit.parking.service.orders.OrdersService;
import com.qhit.parking.service.park.ParkService;
import com.qhit.parking.service.user.UserService;
import com.qhit.parking.utils.OrderCode;
import com.qhit.parking.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 爸爸 on 2019/5/30.
 */
@Controller
public class FrontController {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private UserService userService;

    @Autowired
    private ParkService ParkService;

    @Autowired
    private OrdersService ordersService;



    @RequestMapping("/")
    public String frontIndex(Model model){
        List<Notice> notices = noticeService.selectAll();
        model.addAttribute("noticeList",notices);
        return "front/index";
    }
    @RequestMapping("/join")
    public String join(Model model){
        return "front/join";
    }
    @RequestMapping("/user/login")
    public String userLogin(Model model, User user, HttpServletRequest request, HttpSession session){
        User userByNameAndPwd = userService.findUserByNameAndPwd(user);
        if(userByNameAndPwd!=null){
            session.setAttribute("LogUser",userByNameAndPwd);
            return "forward:/front/list";
        }
        return "front/join";
    }
    @RequestMapping("/front/list")
    public String list(Model model){
        List<Park> parks = ParkService.selectAll();
        model.addAttribute("parkList",parks);
        return "front/list";
    }

    @RequestMapping("/park-detail")
    public String parkDetail(HttpSession session,Integer id,Model model){
        User logUser = (User)session.getAttribute("LogUser");
        if(logUser!=null){
            Park park = ParkService.selectByPrimaryKey(id);
            model.addAttribute("park",park);
            return "front/detail";
        }
        return "front/join";
    }

    @RequestMapping("/front/buy")
    public String frontBuy(Integer id,HttpSession session){
        int i = ParkService.updateStatusBuyById(id);
        if(i>0){
            User logUser = (User) session.getAttribute("LogUser");
            Orders order = new Orders();
            order.setParkId(id);
            order.setCode(OrderCode.getOrderCode());
            order.setUserId(logUser.getId());
            int insert = ordersService.insert(order);
            if(insert>0){
                return "forward:/front/list";
            }
        }
        return "front/404";

    }
    @RequestMapping("/front/user-show")
    public String userShow(Integer id,Model model){
        User user = userService.selectByPrimaryKey(id);
        model.addAttribute("userinfo",user);
        return "front/user-show";
    }
    @RequestMapping("/front/showOrder")
    public String showOrder(Integer id,Model model){
        List<Orders> orders = ordersService.findOrdersByUid(id);
        model.addAttribute("orderList",orders);
        return  "front/orderList";
    }

    @RequestMapping("/front/jiesuan")
    public String jiesuan(Integer id,Model model){
        Orders order = ordersService.selectOrderByid(id);
        int parkId=order.getParkId();
        Integer userId = order.getUserId();
        Date endTime = new Date();
        HashMap<String,Long> map = TimeUtil.formatDuring(order.getCreatedate(), endTime);
        int days =  map.get("days").intValue();
        int tHours = days * 24 + map.get("hours").intValue();
        int hours =  map.get("minutes") < 30 ? tHours : tHours + 1;
        Double price = order.getPark().getPrice();
        Double total =  price * hours;
        order.setEnddate(endTime);
        order.setTotal( total);
        order.setSumpark(hours);
        order.setStatus(1);
        int i = ordersService.updateByPrimaryKey(order);
        if(i>0){
            int o = ParkService.updateStatusVacantById(parkId);
            return "forward:/front/showOrder?id="+userId;
        }
        return  "forward:/front/list";
    }

}

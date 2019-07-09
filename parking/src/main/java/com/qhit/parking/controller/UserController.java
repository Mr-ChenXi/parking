package com.qhit.parking.controller;

import com.qhit.parking.entity.Admin;
import com.qhit.parking.entity.Orders;
import com.qhit.parking.entity.User;
import com.qhit.parking.service.orders.OrdersService;
import com.qhit.parking.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 爸爸 on 2019/5/27.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService ;

    @Autowired
    private OrdersService ordersService ;

    @RequestMapping("/list")
    public String list(Model model){
        List<User> users = userService.selectAll();
        model.addAttribute("userList",users);
        return "user/user-list";
    }

    @RequestMapping("/deluser")
    @ResponseBody
    public String deluser(Integer userId){
        List<Orders> orders = ordersService.selectByUser_id(userId);
        String result="";
        if(orders.size()!=0){
            int i = userService.updateById(userId);
            if(i>0){
                result="Y";
            }else {
                result="N";
            }
        }else {
            int i = userService.deleteByPrimaryKey(userId);
            if(i>0){
                result="Y";
            }else {
                result="N";
            }
        }
        return result;
    }
    @RequestMapping("/stopUser")
    @ResponseBody
    public HashMap stopUser(Integer userId)  {
        int i = userService.updateStop(userId);
        HashMap map=new HashMap();
        if(i!=0){
            map.put("res","0");
        }else {
            map.put("res","1");
        }
        return map;
    }
    @RequestMapping("/startUser")
    @ResponseBody
    public HashMap startAdmin(Integer userId){
        int i = userService.updateStart(userId);
        HashMap map=new HashMap();
        if(i!=0){
            map.put("res","0");
        }else {
            map.put("res","1");
        }
        return map;
    }
    @RequestMapping("/findUserByName")
    public String findUserByName(User user, Model model){
        List<User> users = userService.findUserByName(user);
        model.addAttribute("userList",users);
        return "user/user-list";
    }
}

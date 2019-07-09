package com.qhit.parking.controller;

import com.qhit.parking.entity.Admin;
import com.qhit.parking.entity.Orders;
import com.qhit.parking.service.orders.OrdersService;
import com.qhit.parking.utils.ExcelUtiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 爸爸 on 2019/5/27.
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/order-list")
    public String orderList(Model model){
        List<Orders> orders = ordersService.selectAll();
        model.addAttribute("orderList",orders);
        return "order/order-list";
    }
    @RequestMapping("/findOrderByKey")
    public String findOrderByKey(String keyTmp, Model model){
        List<Orders> orders = ordersService.findOrderByKey(keyTmp);
        model.addAttribute("orderList",orders);
        return "order/order-list";
    }
    @RequestMapping("/exportStuInfoExcel")
    @ResponseBody
    public void exportStuInfoExcel(HttpServletResponse response){
        List<Orders> orders = ordersService.selectAll();
        /**
         * List<?> list, String title, String sheetName, Class<?> pojoClass,String fileName,
         HttpServletResponse response
         */
        ExcelUtiles.exportExcel(orders,"订单列表","订单",Orders.class,"订单列表.xls",response);
    }
}

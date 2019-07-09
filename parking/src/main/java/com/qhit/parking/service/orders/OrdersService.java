package com.qhit.parking.service.orders;

import com.qhit.parking.entity.Orders;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/27.
 */
public interface OrdersService {


    List<Orders> selectByUser_id(Integer uid);

    List<Orders> selectAll();

    List<Orders> findOrderByKey(String keyTmp);

    int insert(Orders record);

    List<Orders> findOrdersByUid(Integer uid);

    Orders selectOrderByid(Integer id);

    int updateByPrimaryKey(Orders record);
}

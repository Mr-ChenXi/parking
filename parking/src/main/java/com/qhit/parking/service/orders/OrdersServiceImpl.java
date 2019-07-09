package com.qhit.parking.service.orders;

import com.qhit.parking.dao.OrdersMapper;
import com.qhit.parking.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/27.
 */
@Service
public class OrdersServiceImpl implements  OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Override
    public  List<Orders> selectByUser_id(Integer uid) {
        return ordersMapper.selectByUser_id(uid);
    }

    @Override
    public List<Orders> selectAll() {
        return ordersMapper.selectAll();
    }

    @Override
    public List<Orders> findOrderByKey(String keyTmp) {
        return ordersMapper.findOrderByKey(keyTmp);
    }

    @Override
    public int insert(Orders record) {
        return ordersMapper.insert(record);
    }

    @Override
    public List<Orders> findOrdersByUid(Integer uid) {
        return ordersMapper.findOrdersByUid(uid);
    }

    @Override
    public Orders selectOrderByid(Integer id) {
        return ordersMapper.selectOrderByid(id);
    }

    @Override
    public int updateByPrimaryKey(Orders record) {
        return ordersMapper.updateByPrimaryKey(record);
    }
}

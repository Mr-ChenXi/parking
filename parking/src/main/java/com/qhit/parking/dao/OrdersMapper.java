package com.qhit.parking.dao;

import com.qhit.parking.entity.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    Orders selectOrderByid(Integer id);

    List<Orders> selectByUser_id(Integer uid);

    List<Orders> selectAll();

    int updateByPrimaryKey(Orders record);

    List<Orders> findOrderByKey(@Param("keyTmp") String keyTmp);

    List<Orders> findOrdersByUid(Integer uid);

}
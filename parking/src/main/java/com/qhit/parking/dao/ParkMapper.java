package com.qhit.parking.dao;

import com.qhit.parking.entity.Park;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Park record);

    Park selectByPrimaryKey(Integer id);

    List<Park> selectAll();

    int updateByPrimaryKey(Park record);

    int updateStatusBuyById(Integer id);

    int updateStatusVacantById(Integer id);

    int batchInsert(List<Park> parks);


}
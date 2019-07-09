package com.qhit.parking.service.park;

import com.qhit.parking.entity.Park;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/27.
 */
public interface ParkService {
    List<Park> selectAll();

    int insert(Park record);

    int batchInsert(List<Park> parks);

    Park selectByPrimaryKey(Integer id);

    int updateStatusBuyById(Integer id);

    int updateStatusVacantById(Integer id);

}

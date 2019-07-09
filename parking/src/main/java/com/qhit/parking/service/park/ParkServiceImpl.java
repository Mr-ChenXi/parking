package com.qhit.parking.service.park;

import com.qhit.parking.dao.ParkMapper;
import com.qhit.parking.entity.Park;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/27.
 */
@Service
public class ParkServiceImpl implements  ParkService {

    @Autowired
    private ParkMapper parkMapper;
    @Override
    public List<Park> selectAll() {
        return parkMapper.selectAll();
    }

    @Override
    public int insert(Park record) {
        return parkMapper.insert(record);
    }

    @Override
    public int batchInsert(List<Park> parks) {
        return parkMapper.batchInsert(parks);
    }

    @Override
    public Park selectByPrimaryKey(Integer id) {
        return parkMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateStatusBuyById(Integer id) {
        return parkMapper.updateStatusBuyById(id);
    }

    @Override
    public int updateStatusVacantById(Integer id) {
        return parkMapper.updateStatusVacantById(id);
    }
}

package com.qhit.parking.service.notice;

import com.qhit.parking.dao.NoticeMapper;
import com.qhit.parking.entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/28.
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public List<Notice> selectAll() {
        return noticeMapper.selectAll();
    }

    @Override
    public Notice selectByPrimaryKey(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int noticeUpdate(Notice record) {
        return noticeMapper.noticeUpdate(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return noticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Notice record) {
        return noticeMapper.insert(record);
    }
}

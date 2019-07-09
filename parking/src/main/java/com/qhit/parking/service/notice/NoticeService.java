package com.qhit.parking.service.notice;

import com.qhit.parking.entity.Notice;
import com.qhit.parking.entity.Orders;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/28.
 */
public interface NoticeService {

    List<Notice> selectAll();

    Notice selectByPrimaryKey(Integer id);

    int noticeUpdate(Notice record);

    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);
}

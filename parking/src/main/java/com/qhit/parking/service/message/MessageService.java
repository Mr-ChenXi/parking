package com.qhit.parking.service.message;

import com.qhit.parking.entity.Message;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/28.
 */
public interface MessageService {

    List<Message> selectAll();
}

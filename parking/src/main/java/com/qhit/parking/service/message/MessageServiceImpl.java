package com.qhit.parking.service.message;

import com.qhit.parking.dao.MessageMapper;
import com.qhit.parking.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/28.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;
    @Override
    public List<Message> selectAll() {
        return messageMapper.selectAll();
    }
}

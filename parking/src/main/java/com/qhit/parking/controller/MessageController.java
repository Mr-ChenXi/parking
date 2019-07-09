package com.qhit.parking.controller;

import com.qhit.parking.entity.Message;
import com.qhit.parking.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 爸爸 on 2019/5/28.
 */
@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/message-list")
    public String messageList(Model model){
        List<Message> messages = messageService.selectAll();
        model.addAttribute("messageList",messages);
        return  "message/message-list";
    }
}

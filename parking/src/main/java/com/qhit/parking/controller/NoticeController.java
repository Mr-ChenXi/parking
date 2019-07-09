package com.qhit.parking.controller;

import com.qhit.parking.entity.Notice;
import com.qhit.parking.service.notice.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 爸爸 on 2019/5/28.
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @RequestMapping("/noticeList")
    public String noticeList(Model model){

        List<Notice> notices = noticeService.selectAll();
        model.addAttribute("noticeList",notices);
        return "notice/notice-list";
    }

    @RequestMapping("/notice-edit")
    public String noticeEdit(Integer noticeId,Model model){
        Notice notice = noticeService.selectByPrimaryKey(noticeId);
        model.addAttribute("notice",notice);
        return "notice/notice-edit";
    }
    @RequestMapping("/notice-update")
    @ResponseBody
    public HashMap noticeUpdate(Notice notice){
        int i = noticeService.noticeUpdate(notice);
        HashMap map=new HashMap();
        if(i!=0){
            map.put("res","0");
        }else {
            map.put("res","1");
        }
        return map;
    }

    @RequestMapping("/delNotice")
    @ResponseBody
    public HashMap delNotice(Integer noticeId){
        int i = noticeService.deleteByPrimaryKey(noticeId);
        HashMap map=new HashMap();
        if(i!=0){
            map.put("res","0");
        }else {
            map.put("res","1");
        }
        return map;
    }
    @RequestMapping("/notice-add")
    public String noticeAdd(){
        return  "notice/notice-add";
    }
    @RequestMapping("/notice-save")
    @ResponseBody
    public HashMap noticeSave(Notice notice){
        int i = noticeService.insert(notice);
        HashMap map=new HashMap();
        if(i!=0){
            map.put("res","0");
        }else {
            map.put("res","1");
        }
        return map;
    }
}


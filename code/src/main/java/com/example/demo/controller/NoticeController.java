package com.example.demo.controller;

import com.example.demo.entity.Notice;
import com.example.demo.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping("getNotice")
    public List<Notice> getNotice() {
        return noticeService.getNotice();
    }
    @RequestMapping("checkNoticeByname")
    public List<Notice> checkNoticeByname(String uname) {
        return noticeService.checkNoticeByname(uname);
    }
    @RequestMapping("checkNotice")
    public Notice checkNotice(int id) {
        return noticeService.checkNotice(id);
    }
    @RequestMapping("addNotice")
    public int addNotice(String uname,String uid,String address,String uinfo,String picture,String lei,String fdate,String detail){
        return noticeService.addNotice( uname,uid, address, uinfo,picture,lei, fdate,detail);
    }
    @RequestMapping("delNotice")
    public int delNotice(int id) {
        return noticeService.delNotice(id);
    }
    @RequestMapping("updateNotice")
    public  int updateNotice(int id,String uname,String uid,String address,String uinfo,String picture,String lei,String fdate,String detail) {
        return noticeService.updateNotice(id,uname,uid,address,uinfo,picture,lei,fdate,detail);
    }

}

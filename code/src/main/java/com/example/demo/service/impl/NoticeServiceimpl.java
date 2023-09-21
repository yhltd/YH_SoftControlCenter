package com.example.demo.service.impl;




import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Notice;
import com.example.demo.mapper.NoticeMapper;
import com.example.demo.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoticeServiceimpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> getNotice(){
        return noticeMapper.getNotice();
    };

    @Override
    public List<Notice> getNoticeById(int id){
        return noticeMapper.getNoticeById(id);
    };

    @Override
    public Notice checkNotice(int id){
        return noticeMapper.checkNotice(id);
    };

    @Override
    public List<Notice> checkNoticeByname(String uname){
        return noticeMapper.checkNoticeByname(uname);
    };

    @Override
    public int addNotice(String uname,String uid,String address,String uinfo,String lei,String fdate,String detail){
        return noticeMapper.addNotice(uname,uid, address, uinfo,lei, fdate,detail);
    };

    @Override
    public int delNotice(int id){
        return noticeMapper.delNotice(id);
    };

    @Override
    public  int updateNotice(int id,String uname,String uid,String address,String uinfo,String lei,String fdate,String detail){
        return noticeMapper.updateNotice(id,uname,uid,address,uinfo,lei,fdate,detail);
    };

    @Override
    public boolean update(Notice notice) {
        return updateById(notice);
    }

}

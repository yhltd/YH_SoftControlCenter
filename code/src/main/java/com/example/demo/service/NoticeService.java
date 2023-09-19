package com.example.demo.service;

import com.example.demo.entity.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface NoticeService {

    public List<Notice> getNotice();

    public Notice checkNotice(int id);

    public List<Notice> checkNoticeByname(String uname);

    public int addNotice(String uname,String uid,String address,String uinfo,String picture,String lei,String fdate,String detail);

    public int delNotice(int id);

    public  int updateNotice(int id,String uname,String uid,String address,String uinfo,String picture,String lei,String fdate,String detail);
}

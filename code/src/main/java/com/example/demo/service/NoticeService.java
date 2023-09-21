package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface NoticeService extends IService<Notice> {

    public List<Notice> getNotice();

    public List<Notice> getNoticeById(int id);

    public Notice checkNotice(int id);

    public List<Notice> checkNoticeByname(String uname);

    public int addNotice(String uname,String uid,String address,String uinfo,String lei,String fdate,String detail);

    public int delNotice(int id);

    public  int updateNotice(int id,String uname,String uid,String address,String uinfo,String lei,String fdate,String detail);

    /**
     * 修改
     */
    boolean update(Notice notice);
}

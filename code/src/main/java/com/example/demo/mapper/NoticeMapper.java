package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.demo.entity.Notice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
@DS("notice")
public interface NoticeMapper {
    //查
    @Select("select * from notice ")
    public List<Notice> getNotice();


    //查详细
    @Select("select * from notice  where id=#{id}")
    public Notice checkNotice(int id);

    //查一个
    //增
    @Insert("insert into notice(uname,uid,address,uinfo,picture,lei,fdate,detail )values( #{uname} ,#{uid}, #{address},#{uinfo},#{picture},#{lei},#{fdate},#{detail})")
    public int addNotice(String uname,String uid,String address,String uinfo,String picture,String lei,String fdate,String detail);


    @Select("select * from notice  where uname like '%' + #{uname} + '%'")
    public List<Notice> checkNoticeByname(String uname);


    //删
    @Delete("delete from notice where id=#{id} ")
    public int delNotice(int id);

    //改
    @Update("update notice set uname=#{uname} ,uid=#{uid}, address=#{address},uinfo=#{uinfo},picture=#{picture},lei=#{lei},fdate=#{fdate} where id=#{id} ")
    public  int updateNotice(int id,String uname,String uid,String address,String uinfo,String picture,String lei,String fdate,String detail);










}

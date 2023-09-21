package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Notice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
@DS("notice")
public interface NoticeMapper extends BaseMapper<Notice> {
    //查
    @Select("select id,uname,uid,address,uinfo,lei,fdate,detail from notice ")
    public List<Notice> getNotice();


    //查详细
    @Select("select id,uname,uid,address,uinfo,lei,fdate,detail from notice  where id=#{id}")
    public Notice checkNotice(int id);

    //查一个
    //增
    @Insert("insert into notice(uname,uid,address,uinfo,lei,fdate,detail )values( #{uname} ,#{uid}, #{address},#{uinfo},#{lei},#{fdate},#{detail})")
    public int addNotice(String uname,String uid,String address,String uinfo,String lei,String fdate,String detail);


    @Select("select id,uname,uid,address,uinfo,lei,fdate,detail from notice  where uname like '%' + #{uname} + '%'")
    public List<Notice> checkNoticeByname(String uname);


    //删
    @Delete("delete from notice where id=#{id} ")
    public int delNotice(int id);

    //改
    @Update("update notice set uname=#{uname} ,uid=#{uid}, address=#{address},uinfo=#{uinfo},lei=#{lei},fdate=#{fdate},detail=#{detail} where id=#{id} ")
    public  int updateNotice(int id,String uname,String uid,String address,String uinfo,String lei,String fdate,String detail);

    @Select("select * from notice  where id = #{id}")
    public List<Notice> getNoticeById(int id);


}

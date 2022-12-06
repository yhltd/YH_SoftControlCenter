package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.FenquanUser;
import com.example.demo.entity.JiaowuUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 17:37
 */
@Mapper
@Repository
@DS("jiaowu")
public interface JiaowuUserMapper extends BaseMapper<JiaowuUser> {
    @Select("select * from teacher order by id desc")
    List<JiaowuUser> getId();

    @Select("select * from teacher where Company like concat('%',#{company},'%') and UserName like concat('%',#{username},'%') ")
    List<JiaowuUser> getList(String company, String username);

    @Update("update teacher set state='禁用' where id=#{id} ")
    boolean jinyong(int id);

    @Update("update teacher set state='正常' where id=#{id} ")
    boolean jiejin(int id);
}

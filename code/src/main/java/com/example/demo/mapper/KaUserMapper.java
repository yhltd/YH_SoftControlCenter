package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.JiaowuUser;
import com.example.demo.entity.KaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 18:15
 */
@Mapper
@Repository
@DS("ka")
public interface KaUserMapper extends BaseMapper<KaUser> {
    @Select("select * from users order by id desc")
    List<KaUser> getId();

    @Select("select * from users where company like concat('%',#{company},'%') and uname like concat('%',#{username},'%') ")
    List<KaUser> getList(String company, String username);
}

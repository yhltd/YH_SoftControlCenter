package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.SchedulingUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 17:02
 */
@Mapper
@Repository
@DS("scheduling")
public interface SchedulingUserMapper extends BaseMapper<SchedulingUser> {
    @Select("select top 1 * from user_info order by id desc")
    List<SchedulingUser> getId();
}

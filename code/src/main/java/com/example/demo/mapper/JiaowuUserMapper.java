package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.JiaowuUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
}

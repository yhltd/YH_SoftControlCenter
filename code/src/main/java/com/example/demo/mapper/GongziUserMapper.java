package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.GongziUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 16:21
 */
@Mapper
@Repository
@DS("gongzi_fenquan")
public interface GongziUserMapper extends BaseMapper<GongziUser> {
    @Select("select top 1 * from gongzi_renyuan order by id desc")
    List<GongziUser> getId();

}

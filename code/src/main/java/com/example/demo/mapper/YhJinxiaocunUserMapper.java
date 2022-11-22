package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.YhJinxiaocunUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/18 18:20
 */
@Mapper
@Repository
@DS("jxc")
public interface YhJinxiaocunUserMapper extends BaseMapper<YhJinxiaocunUser> {
    @Select("select * from yh_jinxiaocun_user")
    List<YhJinxiaocunUser> getList();
}

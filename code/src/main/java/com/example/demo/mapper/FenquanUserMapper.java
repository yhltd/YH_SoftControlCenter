package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.FenquanUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author hui
 * @date 2022/11/21 18:48
 */
@Mapper
@Repository
@DS("gongzi_fenquan")
public interface FenquanUserMapper extends BaseMapper<FenquanUser> {

}

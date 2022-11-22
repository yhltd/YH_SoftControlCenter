package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.JiaowuPower;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author hui
 * @date 2022/11/21 17:39
 */
@Mapper
@Repository
@DS("jiaowu")
public interface JiaowuPowerMapper extends BaseMapper<JiaowuPower> {
}

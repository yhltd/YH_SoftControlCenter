package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.SchedulingPower;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author hui
 * @date 2022/11/21 17:03
 */
@Mapper
@Repository
@DS("scheduling")
public interface SchedulingPowerMapper extends BaseMapper<SchedulingPower> {

}

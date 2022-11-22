package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.ControlSoftTime;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author hui
 * @date 2022/11/16 14:11
 */
@Mapper
@Repository
@DS("control")
public interface ControlSoftTimeMapper extends BaseMapper<ControlSoftTime> { }

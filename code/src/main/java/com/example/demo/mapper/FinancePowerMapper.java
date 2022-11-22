package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.FinancePower;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author hui
 * @date 2022/11/21 15:09
 */
@Mapper
@Repository
@DS("finance")
public interface FinancePowerMapper extends BaseMapper<FinancePower> {

}

package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.KaPower;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author hui
 * @date 2022/11/21 18:17
 */
@Mapper
@Repository
@DS("ka")
public interface KaPowerMapper extends BaseMapper<KaPower> {
}

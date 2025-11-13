package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.JiaowuPowerServer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
@DS("jiaowumssql")
public interface JiaowuPowerServerMapper extends BaseMapper<JiaowuPowerServer> {
}

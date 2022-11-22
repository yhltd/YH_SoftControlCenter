package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.FenquanPower1;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author hui
 * @date 2022/11/21 18:50
 */
@Mapper
@Repository
@DS("gongzi_fenquan")
public interface FenquanPower1Mapper extends BaseMapper<FenquanPower1> {
}

package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.FenquanUser;
import com.example.demo.entity.FinanceUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 15:09
 */
@Mapper
@Repository
@DS("finance")
public interface FinanceUserMapper extends BaseMapper<FinanceUser> {
    @Select("select * from account where company like '%'+#{company}+'%' and name like '%'+#{username}+'%' ")
    List<FinanceUser> getList(String company, String username);

    @Select("select company from account group by company ")
    List<FinanceUser> getCompany();


}

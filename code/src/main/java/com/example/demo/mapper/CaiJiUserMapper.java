package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.CaiJiUser;
import com.example.demo.entity.FinanceUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 15:09
 */
@Mapper
@Repository
@DS("caiji")
public interface CaiJiUserMapper extends BaseMapper<CaiJiUser> {
    @Select("select * from userInfo where company like '%'+#{company}+'%' and username like '%'+#{username}+'%' ")
    List<CaiJiUser> getList(String company, String username);

    @Select("select company from userInfo group by company ")
    List<CaiJiUser> getCompany();

    @Delete("delete from form_create where company=#{company} ")
    boolean deleteCompany1(String company);

    @Delete("delete from userInfo where company=#{company} ")
    boolean deleteCompany2(String company);
}

package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.JiaowuUser;
import com.example.demo.entity.KaUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 18:15
 */
@Mapper
@Repository
@DS("ka")
public interface KaUserMapper extends BaseMapper<KaUser> {
    @Select("select * from users order by id desc")
    List<KaUser> getId();

//    @Select("select * from users where company like concat('%',#{company},'%') and uname like concat('%',#{username},'%') ")
//    305改 因为门店收银系统 因为SQL语句字段uname 写的不对查询的是用户名 应该查询账号所以查询不到账号数据 uname改成account
    @Select("select * from users where company like concat('%',#{company},'%') and account like concat('%',#{username},'%') ")
    List<KaUser> getList(String company, String username);

    @Select("select company from users group by company")
    List<KaUser> getCompany();

    @Delete("delete from customer where gongsi=#{company} ")
    boolean deleteCompany1(String company);

    @Delete("delete from day_trading where gongsi=#{company} ")
    boolean deleteCompany2(String company);

    @Delete("delete from member_info where company=#{company} ")
    boolean deleteCompany3(String company);

    @Delete("delete from member_jibie where company=#{company} ")
    boolean deleteCompany4(String company);

    @Delete("delete from orders where company=#{company} ")
    boolean deleteCompany5(String company);

    @Delete("delete from orders_details where company=#{company} ")
    boolean deleteCompany6(String company);

    @Delete("delete from preferential_scheme where company=#{company} ")
    boolean deleteCompany7(String company);

    @Delete("delete from product where company=#{company} ")
    boolean deleteCompany8(String company);

    @Delete("delete from users where company=#{company} ")
    boolean deleteCompany9(String company);
}

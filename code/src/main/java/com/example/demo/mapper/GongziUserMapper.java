package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.FinanceUser;
import com.example.demo.entity.GongziUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 16:21
 */
@Mapper
@Repository
@DS("gongzi_fenquan")
public interface GongziUserMapper extends BaseMapper<GongziUser> {
    @Select("select top 1 * from gongzi_renyuan order by id desc")
    List<GongziUser> getId();

    @Select("select * from gongzi_renyuan where L like '%'+#{company}+'%' and I like '%'+#{username}+'%' ")
    List<GongziUser> getList(String company, String username);

    @Select("select L from gongzi_renyuan group by L ")
    List<GongziUser> getCompany();

    @Delete("delete from gongzi_gongzimingxi where BD=#{company} ")
    boolean deleteCompany1(String company);

    @Delete("delete from gongzi_kaoqinjilu where AO=#{company} ")
    boolean deleteCompany2(String company);

    @Delete("delete from gongzi_kaoqinmingxi where K=#{company} ")
    boolean deleteCompany3(String company);

    @Delete("delete from gongzi_peizhi where gongsi=#{company} ")
    boolean deleteCompany4(String company);

    @Delete("delete from gongzi_renyuan where L=#{company} ")
    boolean deleteCompany5(String company);

    @Delete("delete from gongzi_shenpi where gongsi=#{company} ")
    boolean deleteCompany6(String company);

    @Delete("delete from gongzi_shezhi where gongsi=#{company} ")
    boolean deleteCompany7(String company);
}

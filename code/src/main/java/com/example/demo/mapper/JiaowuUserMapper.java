package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.FenquanUser;
import com.example.demo.entity.JiaowuUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 17:37
 */
@Mapper
@Repository
@DS("jiaowu")
public interface JiaowuUserMapper extends BaseMapper<JiaowuUser> {
    @Select("select * from teacher order by id desc")
    List<JiaowuUser> getId();

    @Select("select * from teacher where Company like concat('%',#{company},'%') and UserName like concat('%',#{username},'%') ")
    List<JiaowuUser> getList(String company, String username);

    @Select("select Company from teacher group by Company")
    List<JiaowuUser> getCompany();

    @Update("update teacher set state='禁用' where id=#{id} ")
    boolean jinyong(int id);

    @Update("update teacher set state='正常' where id=#{id} ")
    boolean jiejin(int id);

    @Delete("delete from course where company=#{company} ")
    boolean deleteCompany1(String company);

    @Delete("delete from income where Company=#{company} ")
    boolean deleteCompany2(String company);

    @Delete("delete from jiaoshi where Company=#{company} ")
    boolean deleteCompany3(String company);

    @Delete("delete from kaoqin where company=#{company} ")
    boolean deleteCompany4(String company);

    @Delete("delete from keshi_detail where Company=#{company} ")
    boolean deleteCompany5(String company);

    @Delete("delete from kstj where Company=#{company} ")
    boolean deleteCompany6(String company);

    @Delete("delete from payment where Company=#{company} ")
    boolean deleteCompany7(String company);

    @Delete("delete from power where company=#{company} ")
    boolean deleteCompany8(String company);

    @Delete("delete from shezhi where Company=#{company} ")
    boolean deleteCompany9(String company);

    @Delete("delete from student where Company=#{company} ")
    boolean deleteCompany10(String company);

    @Delete("delete from teacher where Company=#{company} ")
    boolean deleteCompany11(String company);

    @Delete("delete from teacherinfo where company=#{company} ")
    boolean deleteCompany12(String company);

    @Delete("delete from untitled where Company=#{company} ")
    boolean deleteCompany13(String company);
}

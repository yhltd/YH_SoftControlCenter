package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.FenquanUser;
import com.example.demo.entity.SchedulingUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 17:02
 */
@Mapper
@Repository
@DS("scheduling")
public interface SchedulingUserMapper extends BaseMapper<SchedulingUser> {
    @Select("select top 1 * from user_info order by id desc")
    List<SchedulingUser> getId();

    @Select("select * from user_info where company like '%'+#{company}+'%' and user_code like '%'+#{username}+'%' ")
    List<SchedulingUser> getList(String company, String username);

    @Select("select company from user_info group by company ")
    List<SchedulingUser> getCompany();

    @Update("update user_info set state='禁用' where id=#{id} ")
    boolean jinyong(int id);

    @Update("update user_info set state='正常' where id=#{id} ")
    boolean jiejin(int id);

    @Delete("delete from bom_info where company=#{company} ")
    boolean deleteCompany1(String company);

    @Delete("delete from department where company=#{company} ")
    boolean deleteCompany2(String company);

    @Delete("delete from holiday_config where company=#{company} ")
    boolean deleteCompany3(String company);

    @Delete("delete from module_info where company=#{company} ")
    boolean deleteCompany4(String company);

    @Delete("delete from module_type where company=#{company} ")
    boolean deleteCompany5(String company);

    @Delete("delete from order_check where company=#{company} ")
    boolean deleteCompany6(String company);

    @Delete("delete from order_info where company=#{company} ")
    boolean deleteCompany7(String company);

    @Delete("delete from paibanbiao_detail where company=#{company} ")
    boolean deleteCompany8(String company);

    @Delete("delete from paibanbiao_info where remarks1=#{company} ")
    boolean deleteCompany9(String company);

    @Delete("delete from paibanbiao_renyuan where company=#{company} ")
    boolean deleteCompany10(String company);

    @Delete("delete from time_config where company=#{company} ")
    boolean deleteCompany11(String company);

    @Delete("delete from user_info where company=#{company} ")
    boolean deleteCompany12(String company);

    @Delete("delete from work_detail where company=#{company} ")
    boolean deleteCompany13(String company);
}

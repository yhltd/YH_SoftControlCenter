package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.YhJinxiaocunUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/18 18:20
 */
@Mapper
@Repository
@DS("jxc")
public interface YhJinxiaocunUserMapper extends BaseMapper<YhJinxiaocunUser> {
    @Select("select * from yh_jinxiaocun_user where gongsi like concat('%',#{company},'%') and `name` like concat('%',#{username},'%') ")
    List<YhJinxiaocunUser> getList(String company, String username);

    @Select("select gongsi from yh_jinxiaocun_user group by gongsi ")
    List<YhJinxiaocunUser> getCompany();

    @Delete("delete from yh_jinxiaocun_jichuziliao where gs_name=#{company} ")
    boolean deleteCompany1(String company);

    @Delete("delete from yh_jinxiaocun_chuhuofang where gongsi=#{company} ")
    boolean deleteCompany2(String company);

    @Delete("delete from yh_jinxiaocun_chuhuofang where gongsi=#{company} ")
    boolean deleteCompany3(String company);

    @Delete("delete from yh_jinxiaocun_jinhuofang where gongsi=#{company} ")
    boolean deleteCompany4(String company);

    @Delete("delete from yh_jinxiaocun_mingxi where gs_name=#{company} ")
    boolean deleteCompany5(String company);

    @Delete("delete from yh_jinxiaocun_qichushu where gs_name=#{company} ")
    boolean deleteCompany6(String company);

    @Delete("delete from yh_jinxiaocun_user where gongsi=#{company} ")
    boolean deleteCompany7(String company);

    @Delete("delete from yh_jinxiaocun_zhengli where gs_name=#{company} ")
    boolean deleteCompany8(String company);
}

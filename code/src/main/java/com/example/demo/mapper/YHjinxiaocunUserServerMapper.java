package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.yhjinxiaocunUserServer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
@DS("jxcmssql")
public interface YHjinxiaocunUserServerMapper extends BaseMapper<yhjinxiaocunUserServer> {

    @Select("select *,_id as idstr from yh_jinxiaocun_user_mssql where gongsi like '%' + #{company} + '%' and name like '%' + #{username} + '%'")
    List<yhjinxiaocunUserServer> getList(String company, String username);

    @Select("select gongsi from yh_jinxiaocun_user_mssql group by gongsi")
    List<yhjinxiaocunUserServer> getCompany();

    @Delete("delete from yh_jinxiaocun_jichuziliao_mssql where gs_name=#{company}")
    boolean deleteCompany1(String company);

    @Delete("delete from yh_jinxiaocun_chuhuofang_mssql where gongsi=#{company}")
    boolean deleteCompany2(String company);

    @Delete("delete from yh_jinxiaocun_chuhuofang_mssql where gongsi=#{company}")
    boolean deleteCompany3(String company);

    @Delete("delete from yh_jinxiaocun_jinhuofang_mssql where gongsi=#{company}")
    boolean deleteCompany4(String company);

    @Delete("delete from yh_jinxiaocun_mingxi_mssql where gs_name=#{company}")
    boolean deleteCompany5(String company);

    @Delete("delete from yh_jinxiaocun_qichushu_mssql where gs_name=#{company}")
    boolean deleteCompany6(String company);

    @Delete("delete from yh_jinxiaocun_user_mssql where gongsi=#{company}")
    boolean deleteCompany7(String company);

    @Delete("delete from yh_jinxiaocun_zhengli_mssql where gs_name=#{company}")
    boolean deleteCompany8(String company);

    @Delete("delete from yh_jinxiaocun_user_mssql where _id=#{idList}")
    boolean delete(String idList);

    @Update("update yh_jinxiaocun_user_mssql set Btype='锁定' where _id=#{id}")
    boolean jinyong(String id);

    @Update("update yh_jinxiaocun_user_mssql set Btype='正常' where _id=#{id}")
    boolean jiejin(String id);
}

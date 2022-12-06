package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.FenquanUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 18:48
 */
@Mapper
@Repository
@DS("gongzi_fenquan")
public interface FenquanUserMapper extends BaseMapper<FenquanUser> {
    @Select("select * from baitaoquanxian_renyun where B like '%'+#{company}+'%' and D like '%'+#{username}+'%' ")
    List<FenquanUser> getList(String company, String username);

    @Select("select B from baitaoquanxian_renyun group by B ")
    List<FenquanUser> getCompany();

    @Update("update baitaoquanxian_renyun set zhuangtai='锁死' where id=#{id} ")
    boolean jinyong(int id);

    @Update("update baitaoquanxian_renyun set zhuangtai='正常' where id=#{id} ")
    boolean jiejin(int id);
}

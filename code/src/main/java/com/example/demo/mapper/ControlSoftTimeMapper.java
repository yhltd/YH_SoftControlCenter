package com.example.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.CaiJiUser;
import com.example.demo.entity.ControlSoftTime;
import com.example.demo.entity.ControlSoftTime2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/16 14:11
 */
@Mapper
@Repository
@DS("control")
public interface ControlSoftTimeMapper extends BaseMapper<ControlSoftTime> {
    @Select("select _id from control_soft_time where name=#{company} and soft_name=#{name} ")
    List<ControlSoftTime> selectCompany(String name, String company);

    @Select("select max(_id) as maxid from control_soft_time")
    List<ControlSoftTime2> selectId();

    @Select("select * from control_soft_time where soft_name='人事' or soft_name='财务' or soft_name='排产' or soft_name='进销存' or soft_name='卡管理' or soft_name='教务' or soft_name='分权' or soft_name='采集' ")
    List<ControlSoftTime> getList();

    @Select("select * from control_soft_time where (soft_name='人事' or soft_name='财务' or soft_name='排产' or soft_name='进销存' or soft_name='卡管理' or soft_name='教务' or soft_name='分权' or soft_name='采集') and name like '%'+ #{query} +'%' ")
    List<ControlSoftTime> queryList(String query);
}

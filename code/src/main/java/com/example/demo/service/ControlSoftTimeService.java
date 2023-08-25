package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.ControlSoftTime;
import com.example.demo.entity.ControlSoftTime2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author hui
 * @date 2022/11/16 14:09
 */
@Service
public interface ControlSoftTimeService extends IService<ControlSoftTime> {
    /**
     * 登陆
     *
     * @param name 用户名
     * @param password 密码
     * @return 转Json后的用户信息
     */
    Map<String, Object> login(String name, String password);

    /**
     * 删除
     *
     * @param idList 根据id集合删除
     * @return 是否删除成功
     */
    boolean delete(int idList);




    List<ControlSoftTime> selectCompany(String name, String company);


    List<ControlSoftTime2> selectId();

    ControlSoftTime add(ControlSoftTime controlSoftTime);

    List<ControlSoftTime> getList();

    List<ControlSoftTime> queryList(String query);

    /**
     * 修改
     */
    boolean update(ControlSoftTime controlSoftTime);

    /**
     * 删除
     *
     * @param idList 根据id集合删除
     * @return 是否删除成功
     */
    boolean delete(List<Integer> idList);
}

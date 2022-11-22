package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.ControlSoftTime;
import org.springframework.stereotype.Service;

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
}

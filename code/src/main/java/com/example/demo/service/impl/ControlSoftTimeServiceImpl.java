package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.ControlSoftTime;
import com.example.demo.mapper.ControlSoftTimeMapper;
import com.example.demo.service.ControlSoftTimeService;
import com.example.demo.util.GsonUtil;
import com.example.demo.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hui
 * @date 2022/11/16 14:16
 */
@Service
public class ControlSoftTimeServiceImpl extends ServiceImpl<ControlSoftTimeMapper, ControlSoftTime> implements ControlSoftTimeService {
    @Override
    public Map<String, Object> login(String name, String password) {
        //条件构造器
        QueryWrapper<ControlSoftTime> queryWrapper = new QueryWrapper<>();
        //账号
        queryWrapper.eq("name", name);
        //密码
        queryWrapper.eq("password", password);
        //获取User
        ControlSoftTime controlSoftTime = this.getOne(queryWrapper);
        //如果不为空
        String data = StringUtils.EMPTY;
        if (StringUtils.isNotNull(controlSoftTime)) {
            //转JSON
            data = GsonUtil.toJson(controlSoftTime);

            Map<String, Object> map = new HashMap<>();
            map.put("token", data);
            return map;
        }
        return null;
    }
}

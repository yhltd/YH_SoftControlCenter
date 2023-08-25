package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.ControlSoftTime;
import com.example.demo.entity.ControlSoftTime2;
import com.example.demo.entity.YhJinxiaocunUser;
import com.example.demo.mapper.CaiJiUserMapper;
import com.example.demo.mapper.ControlSoftTimeMapper;
import com.example.demo.service.ControlSoftTimeService;
import com.example.demo.util.GsonUtil;
import com.example.demo.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ControlSoftTimeMapper controlSoftTimeMapper;

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

    @Override
    public boolean delete(int idList) {
        return removeById(idList);
    }

    @Override
    public List<ControlSoftTime> selectCompany(String name, String company) {
        return controlSoftTimeMapper.selectCompany(name,company);
    }

    @Override
    public List<ControlSoftTime> getList() {
        return controlSoftTimeMapper.getList();
    }

    @Override
    public boolean update(ControlSoftTime controlSoftTime) {
        return this.updateById(controlSoftTime);
    }

    @Override
    public List<ControlSoftTime> queryList(String query) {
        return controlSoftTimeMapper.queryList(query);
    }

    @Override
    public List<ControlSoftTime2> selectId() {
        return controlSoftTimeMapper.selectId();
    }

    @Override
    public ControlSoftTime add(ControlSoftTime controlSoftTime) {
        return save(controlSoftTime) ? controlSoftTime : null;
    }

    @Override
    public boolean delete(List<Integer> idList) {
        return removeByIds(idList);
    }
}

package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.SchedulingUser;
import com.example.demo.mapper.SchedulingUserMapper;
import com.example.demo.service.SchedulingUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 17:07
 */
@Service
public class SchedulingUserServiceImpl extends ServiceImpl<SchedulingUserMapper, SchedulingUser> implements SchedulingUserService {
    @Autowired
    private SchedulingUserMapper schedulingUserMapper;

    @Override
    public List<SchedulingUser> getId() {
        return schedulingUserMapper.getId();
    }

    @Override
    public SchedulingUser add(SchedulingUser schedulingUser) {
        return save(schedulingUser) ? schedulingUser : null;
    }

    @Override
    public List<SchedulingUser> getList(String company, String username) {
        return schedulingUserMapper.getList(company, username);
    }

    @Override
    public boolean jinyong(int id) {
        return schedulingUserMapper.jinyong(id);
    }

    @Override
    public boolean jiejin(int id) {
        return schedulingUserMapper.jiejin(id);
    }
}

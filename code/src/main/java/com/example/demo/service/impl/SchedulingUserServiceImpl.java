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
    public List<SchedulingUser> getCompany() {
        return schedulingUserMapper.getCompany();
    }

    @Override
    public boolean jinyong(int id) {
        return schedulingUserMapper.jinyong(id);
    }

    @Override
    public boolean jiejin(int id) {
        return schedulingUserMapper.jiejin(id);
    }

    @Override
    public boolean delete(int idList) {
        return removeById(idList);
    }

    @Override
    public boolean deleteCompany(String company) {
        return schedulingUserMapper.deleteCompany1(company) || schedulingUserMapper.deleteCompany2(company) || schedulingUserMapper.deleteCompany3(company) || schedulingUserMapper.deleteCompany4(company) || schedulingUserMapper.deleteCompany5(company) || schedulingUserMapper.deleteCompany6(company) || schedulingUserMapper.deleteCompany7(company) || schedulingUserMapper.deleteCompany8(company) || schedulingUserMapper.deleteCompany9(company) || schedulingUserMapper.deleteCompany10(company) || schedulingUserMapper.deleteCompany11(company) || schedulingUserMapper.deleteCompany12(company) || schedulingUserMapper.deleteCompany13(company);
    }
}

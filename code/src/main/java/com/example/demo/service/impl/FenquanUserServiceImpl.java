package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.FenquanUser;
import com.example.demo.mapper.FenquanUserMapper;
import com.example.demo.service.FenquanUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 18:58
 */
@Service
public class FenquanUserServiceImpl extends ServiceImpl<FenquanUserMapper, FenquanUser> implements FenquanUserService {
    @Autowired
    private FenquanUserMapper fenquanUserMapper;

    @Override
    public FenquanUser add(FenquanUser fenquanUser) {
        return save(fenquanUser) ? fenquanUser : null;
    }

    @Override
    public List<FenquanUser> getList(String company, String username) {
        return fenquanUserMapper.getList(company, username);
    }

    @Override
    public boolean jinyong(int id) {
        return fenquanUserMapper.jinyong(id);
    }

    @Override
    public boolean jiejin(int id) {
        return fenquanUserMapper.jiejin(id);
    }
}

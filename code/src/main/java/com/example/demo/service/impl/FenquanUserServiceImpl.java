package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.FenquanUser;
import com.example.demo.mapper.FenquanUserMapper;
import com.example.demo.service.FenquanUserService;
import org.springframework.stereotype.Service;

/**
 * @author hui
 * @date 2022/11/21 18:58
 */
@Service
public class FenquanUserServiceImpl extends ServiceImpl<FenquanUserMapper, FenquanUser> implements FenquanUserService {
    @Override
    public FenquanUser add(FenquanUser fenquanUser) {
        return save(fenquanUser) ? fenquanUser : null;
    }
}

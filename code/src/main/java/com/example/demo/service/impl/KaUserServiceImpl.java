package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.KaUser;
import com.example.demo.mapper.KaUserMapper;
import com.example.demo.service.KaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 18:22
 */
@Service
public class KaUserServiceImpl extends ServiceImpl<KaUserMapper, KaUser> implements KaUserService {
    @Autowired
    KaUserMapper kaUserMapper;

    @Override
    public List<KaUser> getId() {
        return kaUserMapper.getId();
    }

    @Override
    public KaUser add(KaUser kaUser) {
        return save(kaUser) ? kaUser : null;
    }
}

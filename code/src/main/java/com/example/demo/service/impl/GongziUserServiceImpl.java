package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.GongziUser;
import com.example.demo.mapper.GongziUserMapper;
import com.example.demo.service.GongziUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 16:31
 */
@Service
public class GongziUserServiceImpl extends ServiceImpl<GongziUserMapper, GongziUser> implements GongziUserService {
    @Autowired
    GongziUserMapper gongziUserMapper;

    @Override
    public List<GongziUser> getId() {
        return gongziUserMapper.getId();
    }

    @Override
    public GongziUser add(GongziUser gongziUser) {
        return save(gongziUser) ? gongziUser : null;
    }
}

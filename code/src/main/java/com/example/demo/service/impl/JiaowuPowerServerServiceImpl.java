package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.JiaowuPowerServer;
import com.example.demo.mapper.JiaowuPowerServerMapper;
import com.example.demo.service.JiaowuPowerServerService;
import org.springframework.stereotype.Service;

@Service
public class JiaowuPowerServerServiceImpl extends ServiceImpl<JiaowuPowerServerMapper, JiaowuPowerServer> implements JiaowuPowerServerService {
    @Override
    public JiaowuPowerServer add(JiaowuPowerServer JiaowuPowerServer) {
        return save(JiaowuPowerServer) ? JiaowuPowerServer : null;
    }
}

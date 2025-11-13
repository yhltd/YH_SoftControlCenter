package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.JiaowuPowerServer;
import org.springframework.stereotype.Service;

@Service
public interface JiaowuPowerServerService extends IService<JiaowuPowerServer> {
    JiaowuPowerServer add(JiaowuPowerServer JiaowuPowerServer);
}

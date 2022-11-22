package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.GongziPower;
import com.example.demo.mapper.GongziPowerMapper;
import com.example.demo.service.GongziPowerService;
import org.springframework.stereotype.Service;

/**
 * @author hui
 * @date 2022/11/21 16:35
 */
@Service
public class GongziPowerServiceImpl extends ServiceImpl<GongziPowerMapper, GongziPower> implements GongziPowerService {
    @Override
    public GongziPower add(GongziPower gongziPower) {
        return save(gongziPower) ? gongziPower : null;
    }
}

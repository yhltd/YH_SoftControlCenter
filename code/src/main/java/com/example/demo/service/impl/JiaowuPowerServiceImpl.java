package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.JiaowuPower;
import com.example.demo.mapper.JiaowuPowerMapper;
import com.example.demo.service.JiaowuPowerService;
import org.springframework.stereotype.Service;

/**
 * @author hui
 * @date 2022/11/21 17:53
 */
@Service
public class JiaowuPowerServiceImpl extends ServiceImpl<JiaowuPowerMapper, JiaowuPower> implements JiaowuPowerService {
    @Override
    public JiaowuPower add(JiaowuPower jiaowuPower) {
        return save(jiaowuPower) ? jiaowuPower : null;
    }
}

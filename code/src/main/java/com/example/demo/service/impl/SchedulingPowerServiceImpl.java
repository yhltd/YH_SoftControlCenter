package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.SchedulingPower;
import com.example.demo.mapper.SchedulingPowerMapper;
import com.example.demo.service.SchedulingPowerService;
import org.springframework.stereotype.Service;

/**
 * @author hui
 * @date 2022/11/21 17:09
 */
@Service
public class SchedulingPowerServiceImpl extends ServiceImpl<SchedulingPowerMapper, SchedulingPower> implements SchedulingPowerService {
    @Override
    public SchedulingPower add(SchedulingPower schedulingPower) {
        return save(schedulingPower) ? schedulingPower : null;
    }
}

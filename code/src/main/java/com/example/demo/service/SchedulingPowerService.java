package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.SchedulingPower;
import com.example.demo.entity.SchedulingUser;
import org.springframework.stereotype.Service;

/**
 * @author hui
 * @date 2022/11/21 17:06
 */
@Service
public interface SchedulingPowerService extends IService<SchedulingPower> {
    SchedulingPower add(SchedulingPower schedulingPower);
}

package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.FinancePower;
import com.example.demo.mapper.FinancePowerMapper;
import com.example.demo.service.FinancePowerService;
import org.springframework.stereotype.Service;

/**
 * @author hui
 * @date 2022/11/21 15:15
 */
@Service
public class FinancePowerServiceImpl extends ServiceImpl<FinancePowerMapper, FinancePower> implements FinancePowerService {
    @Override
    public FinancePower add(FinancePower financePower) {
        return save(financePower) ? financePower : null;
    }
}

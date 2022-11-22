package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.FinancePower;
import org.springframework.stereotype.Service;

/**
 * @author hui
 * @date 2022/11/21 15:14
 */
@Service
public interface FinancePowerService extends IService<FinancePower> {
    /**
     * 添加
     */
    FinancePower add(FinancePower financePower);
}

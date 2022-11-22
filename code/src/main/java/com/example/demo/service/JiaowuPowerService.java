package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.JiaowuPower;
import org.springframework.stereotype.Service;

/**
 * @author hui
 * @date 2022/11/21 17:42
 */
@Service
public interface JiaowuPowerService extends IService<JiaowuPower> {
    JiaowuPower add(JiaowuPower jiaowuPower);
}

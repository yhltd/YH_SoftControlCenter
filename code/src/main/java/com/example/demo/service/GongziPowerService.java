package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.GongziPower;
import org.springframework.stereotype.Service;

/**
 * @author hui
 * @date 2022/11/21 16:34
 */
@Service
public interface GongziPowerService extends IService<GongziPower> {
    GongziPower add(GongziPower gongziPower);
}

package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.FenquanPower4;
import org.springframework.stereotype.Service;

/**
 * @author hui
 * @date 2022/11/21 18:55
 */
@Service
public interface FenquanPower4Service extends IService<FenquanPower4> {
    FenquanPower4 add(FenquanPower4 fenquanPower4);
}
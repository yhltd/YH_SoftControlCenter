package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.FenquanPower1;
import org.springframework.stereotype.Service;

/**
 * @author hui
 * @date 2022/11/21 18:52
 */
@Service
public interface FenquanPower1Service extends IService<FenquanPower1> {
    FenquanPower1 add(FenquanPower1 fenquanPower1);
}

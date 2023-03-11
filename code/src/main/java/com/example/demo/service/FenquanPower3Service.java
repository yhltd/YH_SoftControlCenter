package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.FenquanPower3;
import org.springframework.stereotype.Service;

/**
 * @author hui
 * @date 2022/11/21 18:55
 */
@Service
public interface FenquanPower3Service extends IService<FenquanPower3> {
    FenquanPower3 add(FenquanPower3 fenquanPower3);
}
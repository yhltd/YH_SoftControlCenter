package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.FenquanPower2;
import org.springframework.stereotype.Service;

/**
 * @author hui
 * @date 2022/11/21 18:55
 */
@Service
public interface FenquanPower2Service extends IService<FenquanPower2> {
    FenquanPower2 add(FenquanPower2 fenquanPower2);
}

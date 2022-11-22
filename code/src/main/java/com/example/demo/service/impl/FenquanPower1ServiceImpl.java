package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.FenquanPower1;
import com.example.demo.mapper.FenquanPower1Mapper;
import com.example.demo.service.FenquanPower1Service;
import org.springframework.stereotype.Service;

/**
 * @author hui
 * @date 2022/11/21 18:59
 */
@Service
public class FenquanPower1ServiceImpl extends ServiceImpl<FenquanPower1Mapper, FenquanPower1> implements FenquanPower1Service {
    @Override
    public FenquanPower1 add(FenquanPower1 fenquanPower1) {
        return save(fenquanPower1) ? fenquanPower1 : null;
    }
}

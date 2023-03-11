package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.FenquanPower4;
import com.example.demo.mapper.FenquanPower4Mapper;
import com.example.demo.service.FenquanPower4Service;
import org.springframework.stereotype.Service;

@Service
public class FenquanPower4ServiceImpl extends ServiceImpl<FenquanPower4Mapper, FenquanPower4> implements FenquanPower4Service {
    @Override
    public FenquanPower4 add(FenquanPower4 fenquanPower4) {
        return save(fenquanPower4) ? fenquanPower4 : null;
    }
}

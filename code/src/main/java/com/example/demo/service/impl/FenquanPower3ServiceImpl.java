package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.FenquanPower3;
import com.example.demo.mapper.FenquanPower3Mapper;
import com.example.demo.service.FenquanPower3Service;
import org.springframework.stereotype.Service;

@Service
public class FenquanPower3ServiceImpl extends ServiceImpl<FenquanPower3Mapper, FenquanPower3> implements FenquanPower3Service {

    @Override
    public FenquanPower3 add(FenquanPower3 fenquanPower3) {
        return save(fenquanPower3) ? fenquanPower3 : null;
    }

}

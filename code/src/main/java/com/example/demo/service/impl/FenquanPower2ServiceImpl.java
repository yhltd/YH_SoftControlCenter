package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.FenquanPower2;
import com.example.demo.mapper.FenquanPower2Mapper;
import com.example.demo.service.FenquanPower2Service;
import org.springframework.stereotype.Service;

/**
 * @author hui
 * @date 2022/11/21 19:01
 */
@Service
public class FenquanPower2ServiceImpl extends ServiceImpl<FenquanPower2Mapper, FenquanPower2> implements FenquanPower2Service {
    @Override
    public FenquanPower2 add(FenquanPower2 fenquanPower2) {
        return save(fenquanPower2) ? fenquanPower2 : null;
    }
}

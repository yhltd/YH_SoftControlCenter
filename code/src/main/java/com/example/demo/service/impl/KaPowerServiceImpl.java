package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.KaPower;
import com.example.demo.mapper.KaPowerMapper;
import com.example.demo.service.KaPowerService;
import org.springframework.stereotype.Service;

/**
 * @author hui
 * @date 2022/11/21 18:25
 */
@Service
public class KaPowerServiceImpl extends ServiceImpl<KaPowerMapper, KaPower> implements KaPowerService {
    @Override
    public KaPower add(KaPower kaPower) {
        return save(kaPower) ? kaPower : null;
    }
}

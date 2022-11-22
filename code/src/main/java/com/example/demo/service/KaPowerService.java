package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.KaPower;
import org.springframework.stereotype.Service;

/**
 * @author hui
 * @date 2022/11/21 18:19
 */
@Service
public interface KaPowerService extends IService<KaPower> {
    KaPower add(KaPower kaPower);
}

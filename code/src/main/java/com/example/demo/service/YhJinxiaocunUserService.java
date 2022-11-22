package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.YhJinxiaocunUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 10:44
 */
@Service
public interface YhJinxiaocunUserService extends IService<YhJinxiaocunUser> {
    /**
     * 添加
     */
    YhJinxiaocunUser add(YhJinxiaocunUser yhJinxiaocunUser);
}

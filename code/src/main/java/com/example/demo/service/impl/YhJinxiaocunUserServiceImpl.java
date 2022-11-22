package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.YhJinxiaocunUser;
import com.example.demo.mapper.YhJinxiaocunUserMapper;
import com.example.demo.service.YhJinxiaocunUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 10:49
 */
@Service
public class YhJinxiaocunUserServiceImpl extends ServiceImpl<YhJinxiaocunUserMapper, YhJinxiaocunUser> implements YhJinxiaocunUserService {
    @Autowired
    YhJinxiaocunUserMapper yhJinxiaocunUserMapper;

    @Override
    public YhJinxiaocunUser add(YhJinxiaocunUser yhJinxiaocunUser) {
        return save(yhJinxiaocunUser) ? yhJinxiaocunUser : null;
    }


}

package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.SchedulingUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 17:04
 */
@Service
public interface SchedulingUserService extends IService<SchedulingUser> {
    List<SchedulingUser> getId();
    SchedulingUser add(SchedulingUser schedulingUser);
}

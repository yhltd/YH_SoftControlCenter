package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.GongziUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 16:28
 */
@Service
public interface GongziUserService extends IService<GongziUser> {
    List<GongziUser> getId();

    GongziUser add(GongziUser gongziUser);

    List<GongziUser> getList(String company, String username);
}

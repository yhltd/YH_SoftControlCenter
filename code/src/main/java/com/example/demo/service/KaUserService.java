package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.KaUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 18:18
 */
@Service
public interface KaUserService extends IService<KaUser> {
    List<KaUser> getId();

    KaUser add(KaUser kaUser);

    List<KaUser> getList(String company, String username);
}

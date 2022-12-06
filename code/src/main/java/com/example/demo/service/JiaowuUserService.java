package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.JiaowuUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 17:41
 */
@Service
public interface JiaowuUserService extends IService<JiaowuUser> {
    List<JiaowuUser> getId();

    JiaowuUser add(JiaowuUser jiaowuUser);

    List<JiaowuUser> getList(String company, String username);

    boolean jinyong(int id);

    boolean jiejin(int id);
}

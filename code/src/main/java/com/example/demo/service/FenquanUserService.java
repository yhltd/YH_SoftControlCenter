package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.FenquanUser;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 18:51
 */
@Service
public interface FenquanUserService extends IService<FenquanUser> {
    FenquanUser add(FenquanUser fenquanUser);

    List<FenquanUser> getList(String company, String username);

    boolean jinyong(int id);

    boolean jiejin(int id);
}

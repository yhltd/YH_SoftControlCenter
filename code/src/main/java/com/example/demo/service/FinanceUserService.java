package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.FinanceUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 15:12
 */
@Service
public interface FinanceUserService extends IService<FinanceUser> {
    /**
     * 添加
     */
    FinanceUser add(FinanceUser financeUser);

    List<FinanceUser> getList(String company, String username);
}

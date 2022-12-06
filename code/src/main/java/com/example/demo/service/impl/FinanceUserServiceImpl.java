package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.FinanceUser;
import com.example.demo.mapper.FinanceUserMapper;
import com.example.demo.service.FinanceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 15:18
 */
@Service
public class FinanceUserServiceImpl extends ServiceImpl<FinanceUserMapper, FinanceUser> implements FinanceUserService {
    @Autowired
    private FinanceUserMapper financeUserMapper;

    @Override
    public FinanceUser add(FinanceUser financeUser) {
        return save(financeUser) ? financeUser : null;
    }

    @Override
    public List<FinanceUser> getList(String company, String username) {
        return financeUserMapper.getList(company, username);
    }
}

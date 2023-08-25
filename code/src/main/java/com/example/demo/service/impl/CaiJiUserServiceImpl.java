package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.CaiJiUser;
import com.example.demo.entity.FinanceUser;
import com.example.demo.mapper.CaiJiUserMapper;
import com.example.demo.mapper.FinanceUserMapper;
import com.example.demo.service.CaiJiUserService;
import com.example.demo.service.FinanceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 15:18
 */
@Service
public class CaiJiUserServiceImpl extends ServiceImpl<CaiJiUserMapper, CaiJiUser> implements CaiJiUserService {
    @Autowired
    private CaiJiUserMapper caiJiUserMapper;

    @Override
    public CaiJiUser add(CaiJiUser caiJiUser) {
        return save(caiJiUser) ? caiJiUser : null;
    }

    @Override
    public List<CaiJiUser> getList(String company, String username) {
        return caiJiUserMapper.getList(company, username);
    }

    @Override
    public List<CaiJiUser> getCompany() {
        return caiJiUserMapper.getCompany();
    }

    @Override
    public boolean delete(int idList) {
        return removeById(idList);
    }

    @Override
    public boolean deleteCompany(String company) {
        caiJiUserMapper.deleteCompany1(company);
        return caiJiUserMapper.deleteCompany2(company);
    }
}

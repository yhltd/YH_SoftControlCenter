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

    @Override
    public List<FinanceUser> getCompany() {
        return financeUserMapper.getCompany();
    }

    @Override
    public boolean delete(int idList) {
        return removeById(idList);
    }

    @Override
    public boolean deleteCompany(String company) {
        financeUserMapper.deleteCompany1(company);
        financeUserMapper.deleteCompany2(company);
        financeUserMapper.deleteCompany3(company);
        financeUserMapper.deleteCompany4(company);
        financeUserMapper.deleteCompany5(company);
        financeUserMapper.deleteCompany6(company);
        financeUserMapper.deleteCompany7(company);
        financeUserMapper.deleteCompany8(company);
        financeUserMapper.deleteCompany9(company);
        financeUserMapper.deleteCompany10(company);
        financeUserMapper.deleteCompany11(company);
        financeUserMapper.deleteCompany12(company);
        financeUserMapper.deleteCompany13(company);
        financeUserMapper.deleteCompany14(company);
        financeUserMapper.deleteCompany15(company);
        financeUserMapper.deleteCompany16(company);
        return financeUserMapper.deleteCompany17(company);
    }
}

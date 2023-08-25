package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.FenquanUser;
import com.example.demo.mapper.FenquanUserMapper;
import com.example.demo.service.FenquanUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 18:58
 */
@Service
public class FenquanUserServiceImpl extends ServiceImpl<FenquanUserMapper, FenquanUser> implements FenquanUserService {
    @Autowired
    private FenquanUserMapper fenquanUserMapper;

    @Override
    public FenquanUser add(FenquanUser fenquanUser) {
        return save(fenquanUser) ? fenquanUser : null;
    }

    @Override
    public List<FenquanUser> getList(String company, String username) {
        return fenquanUserMapper.getList(company, username);
    }

    @Override
    public List<FenquanUser> getCompany() {
        return fenquanUserMapper.getCompany();
    }

    @Override
    public boolean jinyong(int id) {
        return fenquanUserMapper.jinyong(id);
    }

    @Override
    public boolean jiejin(int id) {
        return fenquanUserMapper.jiejin(id);
    }

    @Override
    public boolean delete(int idList) {
        return removeById(idList);
    }

    @Override
    public boolean deleteCompany(String company) {
        fenquanUserMapper.deleteCompany1(company);
        fenquanUserMapper.deleteCompany2(company);
        fenquanUserMapper.deleteCompany3(company);
        fenquanUserMapper.deleteCompany4(company);
        fenquanUserMapper.deleteCompany5(company);
        fenquanUserMapper.deleteCompany6(company);
        return fenquanUserMapper.deleteCompany7(company);
    }
}

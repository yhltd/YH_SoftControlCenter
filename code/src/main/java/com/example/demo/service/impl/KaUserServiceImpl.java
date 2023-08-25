package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.KaUser;
import com.example.demo.mapper.KaUserMapper;
import com.example.demo.service.KaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 18:22
 */
@Service
public class KaUserServiceImpl extends ServiceImpl<KaUserMapper, KaUser> implements KaUserService {
    @Autowired
    private KaUserMapper kaUserMapper;

    @Override
    public List<KaUser> getId() {
        return kaUserMapper.getId();
    }

    @Override
    public KaUser add(KaUser kaUser) {
        return save(kaUser) ? kaUser : null;
    }

    @Override
    public List<KaUser> getList(String company, String username) {
        return kaUserMapper.getList(company, username);
    }

    @Override
    public List<KaUser> getCompany() {
        return kaUserMapper.getCompany();
    }

    @Override
    public boolean delete(int idList) {
        return removeById(idList);
    }

    @Override
    public boolean deleteCompany(String company) {
        return kaUserMapper.deleteCompany1(company) || kaUserMapper.deleteCompany2(company) || kaUserMapper.deleteCompany3(company) || kaUserMapper.deleteCompany4(company) || kaUserMapper.deleteCompany5(company) || kaUserMapper.deleteCompany6(company) || kaUserMapper.deleteCompany7(company) || kaUserMapper.deleteCompany8(company) || kaUserMapper.deleteCompany9(company);
    }
}

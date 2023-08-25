package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.JiaowuUser;
import com.example.demo.mapper.JiaowuUserMapper;
import com.example.demo.service.JiaowuUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 17:45
 */
@Service
public class JiaowuUserServiceImpl extends ServiceImpl<JiaowuUserMapper, JiaowuUser> implements JiaowuUserService {
    @Autowired
    private JiaowuUserMapper jiaowuUserMapper;

    @Override
    public List<JiaowuUser> getId() {
        return jiaowuUserMapper.getId();
    }

    @Override
    public JiaowuUser add(JiaowuUser jiaowuUser) {
        return save(jiaowuUser) ? jiaowuUser : null;
    }

    @Override
    public List<JiaowuUser> getList(String company, String username) {
        return jiaowuUserMapper.getList(company, username);
    }

    @Override
    public List<JiaowuUser> getCompany() {
        return jiaowuUserMapper.getCompany();
    }

    @Override
    public boolean jinyong(int id) {
        return jiaowuUserMapper.jinyong(id);
    }

    @Override
    public boolean jiejin(int id) {
        return jiaowuUserMapper.jiejin(id);
    }

    @Override
    public boolean delete(int idList) {
        return removeById(idList);
    }

    @Override
    public boolean deleteCompany(String company) {
        jiaowuUserMapper.deleteCompany1(company);
        jiaowuUserMapper.deleteCompany2(company);
        jiaowuUserMapper.deleteCompany3(company);
        jiaowuUserMapper.deleteCompany4(company);
        jiaowuUserMapper.deleteCompany5(company);
        jiaowuUserMapper.deleteCompany6(company);
        jiaowuUserMapper.deleteCompany7(company);
        jiaowuUserMapper.deleteCompany8(company);
        jiaowuUserMapper.deleteCompany9(company);
        jiaowuUserMapper.deleteCompany10(company);
        jiaowuUserMapper.deleteCompany11(company);
        jiaowuUserMapper.deleteCompany12(company);
        return jiaowuUserMapper.deleteCompany13(company);
    }
}

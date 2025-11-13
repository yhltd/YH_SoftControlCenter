package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.JiaowuUserServer;
import com.example.demo.mapper.JiaowuUserServerMapper;
import com.example.demo.service.JiaowuUserServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JiaowuUserServerServiceImpl extends ServiceImpl<JiaowuUserServerMapper, JiaowuUserServer> implements JiaowuUserServerService {

    @Autowired
    private JiaowuUserServerMapper jiaowuUserServerMapper;

    @Override
    public List<JiaowuUserServer> getId() {
        return jiaowuUserServerMapper.getId();
    }

    @Override
    public JiaowuUserServer add(JiaowuUserServer JiaowuUserServer) {
        return save(JiaowuUserServer) ? JiaowuUserServer : null;
    }

    @Override
    public List<JiaowuUserServer> getList(String company, String username) {
        return jiaowuUserServerMapper.getList(company, username);
    }

    @Override
    public List<JiaowuUserServer> getCompany() {
        return jiaowuUserServerMapper.getCompany();
    }

    @Override
    public boolean jinyong(int id) {
        return jiaowuUserServerMapper.jinyong(id);
    }

    @Override
    public boolean jiejin(int id) {
        return jiaowuUserServerMapper.jiejin(id);
    }

    @Override
    public boolean delete(int idList) {
        return removeById(idList);
    }

    @Override
    public boolean deleteCompany(String company) {
        jiaowuUserServerMapper.deleteCompany1(company);
        jiaowuUserServerMapper.deleteCompany2(company);
        jiaowuUserServerMapper.deleteCompany3(company);
        jiaowuUserServerMapper.deleteCompany4(company);
        jiaowuUserServerMapper.deleteCompany5(company);
        jiaowuUserServerMapper.deleteCompany6(company);
        jiaowuUserServerMapper.deleteCompany7(company);
        jiaowuUserServerMapper.deleteCompany8(company);
        jiaowuUserServerMapper.deleteCompany9(company);
        jiaowuUserServerMapper.deleteCompany10(company);
        jiaowuUserServerMapper.deleteCompany11(company);
        jiaowuUserServerMapper.deleteCompany12(company);
        return jiaowuUserServerMapper.deleteCompany13(company);
    }
}

package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.yhjinxiaocunUserServer;
import com.example.demo.mapper.YHjinxiaocunUserServerMapper;
import com.example.demo.service.YhJinxiaocunUserServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YhJinxiaocunUserServerServiceImpl extends ServiceImpl<YHjinxiaocunUserServerMapper, yhjinxiaocunUserServer> implements YhJinxiaocunUserServerService {
    @Autowired
    private YHjinxiaocunUserServerMapper yhJinxiaocunUserMapper;

    @Override
    public yhjinxiaocunUserServer add(yhjinxiaocunUserServer yhjinxiaocunUserServer) {
        return save(yhjinxiaocunUserServer) ? yhjinxiaocunUserServer : null;
    }

    @Override
    public List<yhjinxiaocunUserServer> getList(String company, String username) {
        return yhJinxiaocunUserMapper.getList(company, username);
    }

    @Override
    public List<yhjinxiaocunUserServer> getCompany() {
        return yhJinxiaocunUserMapper.getCompany();
    }

    @Override
    public boolean delete(String idList) {
        return yhJinxiaocunUserMapper.delete(idList);
    }

    @Override
    public boolean deleteCompany(String company) {
        return yhJinxiaocunUserMapper.deleteCompany1(company) || yhJinxiaocunUserMapper.deleteCompany2(company) || yhJinxiaocunUserMapper.deleteCompany3(company) || yhJinxiaocunUserMapper.deleteCompany4(company) || yhJinxiaocunUserMapper.deleteCompany5(company) || yhJinxiaocunUserMapper.deleteCompany6(company) || yhJinxiaocunUserMapper.deleteCompany7(company) || yhJinxiaocunUserMapper.deleteCompany8(company);
    }


    @Override
    public boolean jinyong(String id) {
        return yhJinxiaocunUserMapper.jinyong(id);
    }

    @Override
    public boolean jiejin(String id) {
        return yhJinxiaocunUserMapper.jiejin(id);
    }
}


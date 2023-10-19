package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.YhJinxiaocunUser;
import com.example.demo.mapper.YhJinxiaocunUserMapper;
import com.example.demo.service.YhJinxiaocunUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 10:49
 */
@Service
public class YhJinxiaocunUserServiceImpl extends ServiceImpl<YhJinxiaocunUserMapper, YhJinxiaocunUser> implements YhJinxiaocunUserService {
    @Autowired
    private YhJinxiaocunUserMapper yhJinxiaocunUserMapper;

    @Override
    public YhJinxiaocunUser add(YhJinxiaocunUser yhJinxiaocunUser) {
        return save(yhJinxiaocunUser) ? yhJinxiaocunUser : null;
    }

    @Override
    public List<YhJinxiaocunUser> getList(String company, String username) {
        return yhJinxiaocunUserMapper.getList(company, username);
    }

    @Override
    public List<YhJinxiaocunUser> getCompany() {
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

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
    public boolean jinyong(int id) {
        return jiaowuUserMapper.jinyong(id);
    }

    @Override
    public boolean jiejin(int id) {
        return jiaowuUserMapper.jiejin(id);
    }


}

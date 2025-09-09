package com.example.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.PushNews;
import com.example.demo.mapper.PushNewsMapper;
import com.example.demo.service.PushNewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PushNewsServiceImpl extends ServiceImpl<PushNewsMapper, PushNews> implements PushNewsService {

    @Override
    @DS("notice")
    public List<PushNews> getList() {
        return baseMapper.getList();
    }

    @Override
    @DS("notice")
    public List<PushNews> getLittle(String system,String company) {
        return baseMapper.getLittle(system,company);
    }

    @Override
    @DS("notice")
    public int insertPushNews(PushNews pushNews) {
        return baseMapper.insertPushNews(pushNews);
    }

    @Override
    @DS("notice")
    public int updatePushNews(PushNews pushNews) {
        return baseMapper.updatePushNews(pushNews);
    }

    @Override
    @DS("notice")
    public PushNews getById(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    @DS("notice")
    public int deleteById(Integer id) {
        return baseMapper.deleteById(id);
    }
}

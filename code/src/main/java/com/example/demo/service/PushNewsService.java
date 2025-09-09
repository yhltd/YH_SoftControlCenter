package com.example.demo.service;

import com.example.demo.entity.PushNews;

import java.util.List;

public interface PushNewsService {
    List<PushNews> getList();

    List<PushNews> getLittle(String system,String company);

    int insertPushNews(PushNews pushNews);

    int updatePushNews(PushNews pushNews);

    PushNews getById(Integer id);

    int deleteById(Integer id);

}

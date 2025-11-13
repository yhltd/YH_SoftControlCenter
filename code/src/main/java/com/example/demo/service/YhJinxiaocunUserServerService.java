package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.yhjinxiaocunUserServer;

import java.util.List;

public interface YhJinxiaocunUserServerService extends IService<yhjinxiaocunUserServer> {

    yhjinxiaocunUserServer add(yhjinxiaocunUserServer yhjinxiaocunUserServer);

    List<yhjinxiaocunUserServer> getList(String company, String username);

    List<yhjinxiaocunUserServer> getCompany();

    /**
     * 删除
     *
     * @param idList 根据id集合删除
     * @return 是否删除成功
     */
    boolean delete(String idList);

    /**
     * 删除
     *
     * @param company 根据公司删除
     * @return 是否删除成功
     */
    boolean deleteCompany(String company);


    boolean jinyong(String id);

    boolean jiejin(String id);
}

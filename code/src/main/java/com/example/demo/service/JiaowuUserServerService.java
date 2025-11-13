package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.JiaowuUserServer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JiaowuUserServerService extends IService<JiaowuUserServer> {

    List<JiaowuUserServer> getId();

    JiaowuUserServer add(JiaowuUserServer JiaowuUserServer);

    List<JiaowuUserServer> getList(String company, String username);

    List<JiaowuUserServer> getCompany();

    boolean jinyong(int id);

    boolean jiejin(int id);

    /**
     * 删除
     *
     * @param idList 根据id集合删除
     * @return 是否删除成功
     */
    boolean delete(int idList);

    /**
     * 删除
     *
     * @param company 根据公司删除
     * @return 是否删除成功
     */
    boolean deleteCompany(String company);
}

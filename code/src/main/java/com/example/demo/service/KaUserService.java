package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.KaUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 18:18
 */
@Service
public interface KaUserService extends IService<KaUser> {
    List<KaUser> getId();

    KaUser add(KaUser kaUser);

    List<KaUser> getList(String company, String username);

    List<KaUser> getCompany();

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

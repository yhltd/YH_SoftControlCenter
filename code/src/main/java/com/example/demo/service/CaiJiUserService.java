package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.CaiJiUser;
import com.example.demo.entity.FinanceUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 15:12
 */
@Service
public interface CaiJiUserService extends IService<CaiJiUser> {
    /**
     * 添加
     */
    CaiJiUser add(CaiJiUser caiJiUser);

    List<CaiJiUser> getList(String company, String username);

    List<CaiJiUser> getCompany();

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

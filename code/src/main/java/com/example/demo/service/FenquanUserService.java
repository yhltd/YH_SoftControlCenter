package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.FenquanUser;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 18:51
 */
@Service
public interface FenquanUserService extends IService<FenquanUser> {
    FenquanUser add(FenquanUser fenquanUser);

    List<FenquanUser> getList(String company, String username);

    List<FenquanUser> getCompany();

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

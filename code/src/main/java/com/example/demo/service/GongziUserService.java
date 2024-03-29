package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.GongziUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 16:28
 */
@Service
public interface GongziUserService extends IService<GongziUser> {
    List<GongziUser> getId();

    GongziUser add(GongziUser gongziUser);

    List<GongziUser> getList(String company, String username);

    List<GongziUser> getCompany();

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

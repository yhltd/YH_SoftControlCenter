package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.JiaowuUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 17:41
 */
@Service
public interface JiaowuUserService extends IService<JiaowuUser> {
    List<JiaowuUser> getId();

    JiaowuUser add(JiaowuUser jiaowuUser);

    List<JiaowuUser> getList(String company, String username);

    List<JiaowuUser> getCompany();

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

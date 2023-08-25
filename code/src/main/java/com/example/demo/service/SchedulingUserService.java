package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.SchedulingUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 17:04
 */
@Service
public interface SchedulingUserService extends IService<SchedulingUser> {
    List<SchedulingUser> getId();

    SchedulingUser add(SchedulingUser schedulingUser);

    List<SchedulingUser> getList(String company, String username);

    List<SchedulingUser> getCompany();

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

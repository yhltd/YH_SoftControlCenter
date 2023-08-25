package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.YhJinxiaocunUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hui
 * @date 2022/11/21 10:44
 */
@Service
public interface YhJinxiaocunUserService extends IService<YhJinxiaocunUser> {
    /**
     * 添加
     */
    YhJinxiaocunUser add(YhJinxiaocunUser yhJinxiaocunUser);

    List<YhJinxiaocunUser> getList(String company, String username);

    List<YhJinxiaocunUser> getCompany();

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

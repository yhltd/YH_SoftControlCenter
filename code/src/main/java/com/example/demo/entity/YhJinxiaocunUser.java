package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hui
 * @date 2022/11/18 18:16
 */
@Data
@TableName("yh_jinxiaocun_user")
public class YhJinxiaocunUser {
    private String _id;
    private String adminis;
    private String btype;
    private String gongsi;
    private String name;
    private String password;
}

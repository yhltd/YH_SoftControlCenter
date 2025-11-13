package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("yh_jinxiaocun_user_mssql")
public class yhjinxiaocunUserServer {

    @TableId(value = "_id")
    private String _id;
    private String adminis;
    private String btype;
    private String gongsi;
    private String name;
    private String password;
    private String idstr;
    private String shujuku;
}

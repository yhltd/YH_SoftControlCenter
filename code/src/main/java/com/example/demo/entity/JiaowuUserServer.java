package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("teacher")
public class JiaowuUserServer {

    /**
     * id自增列
     */
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private String username;
    private String password;
    private String state;
    private String company;
}

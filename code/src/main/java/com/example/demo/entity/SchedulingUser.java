package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hui
 * @date 2022/11/21 16:56
 */
@Data
@TableName("user_info")
public class SchedulingUser {
    /**
     * id自增列
     */
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private String userCode;
    private String password;
    private String company;
    private String departmentName;
    private String state;
}

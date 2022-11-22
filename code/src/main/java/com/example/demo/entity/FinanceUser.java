package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hui
 * @date 2022/11/21 13:57
 */
@Data
@TableName("Account")
public class FinanceUser {
    /**
     * id自增列
     */
    @TableId(value = "id" , type = IdType.AUTO)
    private int id;
    private String company;
    private String name;
    private String pwd;
    @TableField("do")
    private String _do;
    private String bianhao;
}

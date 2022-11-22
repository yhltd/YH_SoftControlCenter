package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hui
 * @date 2022/11/21 17:00
 */
@Data
@TableName("department")
public class SchedulingPower {
    /**
     * id自增列
     */
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private String departmentName;
    @TableField("[add]")
    private String add;
    private String del;
    private String upd;
    private String sel;
    private String viewName;
    private String company;
}

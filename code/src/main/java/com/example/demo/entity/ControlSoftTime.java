package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hui
 * @date 2022/11/16 14:02
 */
@Data
@TableName("control_soft_time")
public class ControlSoftTime {
    @TableId(value = "_id")
    private int Id;
    private String name;
    private String starttime;
    private String endtime;
    private String softName;
    private String denglushijian;
    private String password;
    private String pid;
    private String mark1;
    private String mark2;
    private String mark3;
    private String mark4;
    private String mark5;
}

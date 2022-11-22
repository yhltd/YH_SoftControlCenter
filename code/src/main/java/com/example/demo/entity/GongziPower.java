package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hui
 * @date 2022/11/21 16:17
 */
@Data
@TableName("gongzi_renyuanManager")
public class GongziPower {
    private int rId;
    @TableField("[add]")
    private String add;
    private String del;
    private String upd;
    private String sel;
    private String look;
    private String viewId;
}

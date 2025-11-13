package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("power")
public class JiaowuPowerServer {
    /**
     * id自增列
     */
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private int tId;
    private String viewName;
    @TableField("[add]")
    private String add;
    private String del;
    private String upd;
    private String sel;
    private String company;
}

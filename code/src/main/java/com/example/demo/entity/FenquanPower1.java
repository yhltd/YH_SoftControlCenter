package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hui
 * @date 2022/11/21 18:44
 */
@Data
@TableName("baitaoquanxian_copy1")
public class FenquanPower1 {
    /**
     * id自增列
     */
    @TableId(value = "id" , type = IdType.AUTO)
    private int id;
    private String quanxian;
    private String b;
    private String renyuanId;
    private String chashanquanxian;
}

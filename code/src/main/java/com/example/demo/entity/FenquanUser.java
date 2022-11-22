package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hui
 * @date 2022/11/21 18:40
 */
@Data
@TableName("baitaoquanxian_renyun")
public class FenquanUser {
    /**
     * id自增列
     */
    @TableId(value = "id" , type = IdType.AUTO)
    private int id;
    private String b;
    private String d;
    private String e;
    private String bumen;
    private String renyuanId;
    private String zhuangtai;
}

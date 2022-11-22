package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hui
 * @date 2022/11/21 13:57
 */
@Data
@TableName("quanxian")
public class FinancePower {
    /**
     * id自增列
     */
    @TableId(value = "id" , type = IdType.AUTO)
    private int id;
    private String kmzz_add;
    private String kmzz_delete;
    private String kmzz_update;
    private String kmzz_select;
    private String kzxm_add;
    private String kzxm_delete;
    private String kzxm_update;
    private String kzxm_select;
    private String bmsz_add;
    private String bmsz_delete;
    private String bmsz_update;
    private String bmsz_select;
    private String pzhz_add;
    private String pzhz_delete;
    private String pzhz_update;
    private String pzhz_select;
    private String znkb_select;
    private String xjll_select;
    private String zcfz_select;
    private String lysy_select;
    private String jjtz_add;
    private String jjtz_delete;
    private String jjtz_update;
    private String jjtz_select;
    private String jjzz_add;
    private String jjzz_delete;
    private String jjzz_update;
    private String jjzz_select;
    private String zhgl_add;
    private String zhgl_delete;
    private String zhgl_update;
    private String zhgl_select;
    private String bianhao;
}

package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hui
 * @date 2022/11/21 18:46
 */
@Data
@TableName("baitaoquanxian_department")
public class FenquanPower2 {
    /**
     * id自增列
     */
    @TableId(value = "id" , type = IdType.AUTO)
    private int id;
    private String departmentName;
    private String viewName;
    private String company;
    private String ins;
    private String del;
    private String upd;
    private String sel;
}

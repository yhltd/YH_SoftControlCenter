package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("product_pushnews")
public class PushNews {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String gsname;
    private String xtname;
    private String tpname1;
    private String tptop1;
    private String tpname2;
    private String tptop2;
    private String tpname3;
    private String tptop3;
    private String tpname4;
    private String tptop4;
    private String tpname5;
    private String tptop5;
    private String tpname6;
    private String tptop6;
    private String topkuan;
    private String topgao;
    private String xuankuan;
    private String xuangao;
    private Date date;
    private String textbox;
    private String beizhu1;
    private String beizhu2;
    private String beizhu3;
    private String beizhu4;
    private String beizhu5;
    private String beizhu6;
    private String beizhu7;
    private String beizhu8;
    private String beizhu9;
    private String beizhu10;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date qidate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date zhidate;

}


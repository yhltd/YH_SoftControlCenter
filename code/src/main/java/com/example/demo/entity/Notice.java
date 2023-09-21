package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("notice")
public class Notice {
    private String uid;
    private String uname;
    private String address;
    private String uinfo;
    private String picture;
    private String lei;
    private String fdate;
    private String detail;
    private String video;
    private String pictureName;
    private String videoName;
    private int id;
}

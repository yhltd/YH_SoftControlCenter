package com.example.demo.entity;

import lombok.Data;

/**
 * @author hui
 * @date 2022/12/6 14:48
 */
@Data
public class Account {
    private int id;
    private String system;
    private String company;
    private String username;
    private String password;
    private String state;
    private String idstr;
}

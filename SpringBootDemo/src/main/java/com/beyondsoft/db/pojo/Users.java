package com.beyondsoft.db.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Users {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private Date birthday;
}
